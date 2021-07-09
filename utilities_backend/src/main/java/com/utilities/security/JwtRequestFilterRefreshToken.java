/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.security;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtRequestFilterRefreshToken extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain) throws ServletException, IOException {

        final String requestRefreshTokenHeader = request.getHeader("refreshToken");
        final String requestURL = request.getRequestURL().toString();

        final String refreshToken = requestRefreshTokenHeader != null && requestRefreshTokenHeader.startsWith("Bearer ") ? requestRefreshTokenHeader.substring(7) : null;

        if (refreshToken != null && requestURL.contains("refresh-token")) {
            final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(null, null, null);
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            final Claims claims = jwtTokenUtil.getClaimsFromRefreshToken(refreshToken);
            request.setAttribute("claims", claims);
        }
        filterChain.doFilter(request, response);
    }

}
