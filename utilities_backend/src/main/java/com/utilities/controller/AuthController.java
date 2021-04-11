/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.controller;

import com.utilities.dto.AuthRequestDto;
import com.utilities.dto.AuthResponseDto;
import com.utilities.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.utilities.config.Constant.APP_VERSION_URL;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/" + APP_VERSION_URL + "/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    @PostMapping(value = "/token")
    public ResponseEntity<AuthResponseDto> createAuthenticationToken(@RequestBody final AuthRequestDto authRequestDto) {
        authenticate(authRequestDto.getUsername(), authRequestDto.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequestDto.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponseDto(token));
    }

    private void authenticate(final String username, final String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
