package com.smart.contact.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Disable CSRF (Enable in production)
				.authorizeHttpRequests(auth -> auth.requestMatchers("/public/**").permitAll() // Allow public access
						.requestMatchers("/admin/**").hasRole("ADMIN") // Restrict admin access
						.anyRequest().authenticated() // All other requests require authentication
				).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No
																												// sessions
				).formLogin(form -> form.loginPage("/login").permitAll()) // Custom login page
				.logout(logout -> logout.logoutUrl("/logout").permitAll()); // Logout handling

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetatilsServiceImpl();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;
	}
	
	// configuration method
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	        .requestMatchers("/admin/**").hasRole("ADMIN")
	        .requestMatchers("/user/**").hasRole("USER")
	        .requestMatchers("/").permitAll()
	        .and()
	        .formLogin()
	        .and()
	        .csrf().disable();
	}
}
