package com.smart.contact.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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

}
