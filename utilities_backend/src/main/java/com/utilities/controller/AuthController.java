/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.controller;

import com.utilities.dto.AuthRequestDto;
import com.utilities.dto.AuthResponseDto;
import com.utilities.security.JwtTokenUtil;
import com.utilities.service.UserService;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.utilities.config.Constant.APP_VERSION_URL;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/" + APP_VERSION_URL + "/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponseDto> createAuthenticationToken(@RequestBody final AuthRequestDto authRequestDto) {
        authenticate(authRequestDto.getUsername(), authRequestDto.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequestDto.getUsername());

        final String accessToken = jwtTokenUtil.generateToken(userDetails);
        final String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails);

        return ResponseEntity.ok(new AuthResponseDto(accessToken, refreshToken));
    }

    @GetMapping(value = "/refresh-token")
    public ResponseEntity<?> getRefreshToken(final HttpServletRequest request) {
        final DefaultClaims claims = (DefaultClaims) request.getAttribute("claims");

        final String username = claims.getSubject();

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String accessToken = jwtTokenUtil.generateToken(userDetails);
        final String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails);
        return ResponseEntity.ok(new AuthResponseDto(accessToken, refreshToken));
    }

    private void authenticate(final String username, final String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

}
