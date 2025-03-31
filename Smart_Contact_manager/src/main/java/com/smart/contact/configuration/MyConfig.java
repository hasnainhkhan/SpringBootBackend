package com.smart.contact.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyConfig {

    private final LoginRedirect loginRedirect;

    // Constructor Injection for LoginRedirect handler
    public MyConfig(LoginRedirect loginRedirect) {
        this.loginRedirect = loginRedirect;
    }

    // Password Encoder bean using BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // UserDetailsService bean to handle user authentication
    @Bean
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsServiceImpl(); // Ensure this class exists and implements UserDetailsService
    }

    // DaoAuthenticationProvider to authenticate user details with password encoding
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        System.out.println("Password Encoder: " + passwordEncoder()); // Debugging, can be removed in production
        return daoAuthenticationProvider;
    }

    // Security filter chain with HttpSecurity configurations
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/admin/delete/**") // Ignore CSRF for DELETE requests on specific routes
            )
            .authorizeRequests(auth -> auth
                .requestMatchers("/", "/login", "/signup", "/register").permitAll() // Public routes
                .requestMatchers("/static/**", "/static/css/bootstrap.css", "/images/**", "/css/**", "/js/**").permitAll() // Static resources
                .requestMatchers("/admin/**").hasRole("ADMIN") // Protected Admin routes
                .requestMatchers("/user/**").hasRole("USER") // Protected User routes
            )
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler(loginRedirect) // Redirect after successful login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true") // Redirect after logout
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        // Disable CSRF globally if you need to (use with caution)
        // CSRF should only be disabled for certain cases, like for APIs or non-browser-based clients.
        // csrf(csrf -> csrf.disable());

        return http.build();
    }

    // AuthenticationManager bean configuration
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
