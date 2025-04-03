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
                .ignoringRequestMatchers("/admin/delete/**") // Allow delete requests without CSRF
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/", "/login", "/signup", "/register").permitAll()
                .requestMatchers("/static/**", "/static/css/bootstrap.css", "/images/**", "/css/**", "/js/**").permitAll() // Static resources
            )
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler(loginRedirect) // Custom login redirect handler
                .permitAll())}




    // AuthenticationManager bean configuration
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
