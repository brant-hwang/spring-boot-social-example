package com.axisj.examples.spring.social.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLoginFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String message = "";

		if(exception.getClass() == UsernameNotFoundException.class) {
			message = "cannot find a user";
		} else if(exception.getClass() == BadCredentialsException.class) {
			message = "check your password";
		}

		request.getRequestDispatcher(String.format("/error?message=%s", message)).forward(request, response);
	}
}
