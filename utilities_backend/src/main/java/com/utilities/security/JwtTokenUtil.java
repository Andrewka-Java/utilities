/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = 1453829511997616548L;

    private final String secret;
    private final String refreshSecret;
    private final int jwtTokenExpirationMs;
    private final int jwtRefreshExpirationMs;

    public JwtTokenUtil(
            @Value("${jwt.secret}") final String secret,
            @Value("${jwt.refresh.secret}") final String refreshSecret,
            @Value("${jwt.tokenExpirationMs}") final int jwtTokenExpirationMs,
            @Value("${jwt.refreshExpirationMs}") final int jwtRefreshExpirationMs
    ) {
        this.secret = secret;
        this.refreshSecret = refreshSecret;
        this.jwtTokenExpirationMs = jwtTokenExpirationMs;
        this.jwtRefreshExpirationMs = jwtRefreshExpirationMs;
    }

    public String getUsernameFromToken(final String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(final String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(final String token, final Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(final String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(final String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(final UserDetails userDetails) {
        final Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public String generateRefreshToken(final UserDetails userDetails) {
        final Map<String, Object> claims = new HashMap<>();
        return doGenerateRefreshToken(claims, userDetails.getUsername());
    }

    public Claims getClaimsFromRefreshToken(final String refreshToken) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(refreshSecret)
                    .parseClaimsJws(refreshToken)
                    .getBody();
        } catch (final Exception ex) {
            log.error("Could not get all claims Token from passed token");
            claims = null;
        }
        return claims;
    }

    private String doGenerateToken(final Map<String, Object> claims, final String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private String doGenerateRefreshToken(final Map<String, Object> claims, final String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtRefreshExpirationMs))
                .signWith(SignatureAlgorithm.HS512, refreshSecret)
                .compact();
    }

    public Boolean validateToken(final String token, final UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
