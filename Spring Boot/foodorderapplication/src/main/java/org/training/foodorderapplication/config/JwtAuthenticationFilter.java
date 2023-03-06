package org.training.foodorderapplication.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.training.foodorderapplication.dto.Constants;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService detailsService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader(Constants.HEADER_STRING);
		String username = null;
		String jwtToken = null;
		if ((!Objects.isNull(header)) && header.startsWith(Constants.TOKEN_PREFIX)) {
			jwtToken = header.replace(Constants.TOKEN_PREFIX, "");
			try {
				username = jwtTokenUtil.getUserNameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				logger.error("Error occured during getting the user from the token", e);
			} catch (ExpiredJwtException e) {
				logger.warn("Jwt token validation failed", e);
			} catch (SignatureException e) {
				logger.error("Authentication failed, Username and password are not valid");
			}
		} else {
			logger.warn("Couldn't find the bearer string");
		}

		if((!Objects.isNull(username)) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
			
			UserDetails userDetails = detailsService.loadUserByUsername(username);
			
			if(Boolean.TRUE.equals(jwtTokenUtil.validateToken(jwtToken, userDetails))) {
				
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ADMIN")));
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				logger.info("User with username: "+username+" authenticated, setting security context");
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
