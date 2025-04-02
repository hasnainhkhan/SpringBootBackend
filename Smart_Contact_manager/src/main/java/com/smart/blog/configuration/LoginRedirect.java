package com.smart.blog.configuration;

import java.io.IOException;
import java.util.Collection;

import org.hibernate.annotations.Comment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginRedirect  implements AuthenticationSuccessHandler{


	    @Override
	    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	                                        Authentication authentication) throws IOException, ServletException {
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

	        // Check User Role and Redirect Accordingly
	        for (GrantedAuthority authority : authorities) {
	            if (authority.getAuthority().equals("ROLE_ADMIN")) {
	                response.sendRedirect("/admin/index"); //  Admin redirect
	                return;
	            } else if (authority.getAuthority().equals("ROLE_USER")) {
	                response.sendRedirect("/user/index"); //  User redirect
	                return;
	            }
	        }

	        // Default redirect role not match
	        response.sendRedirect("/");
	    }

	
	}


