package com.example.finalproject.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;

@RequiredArgsConstructor
@Component
public class JwtProvider {
    @Value("${jwt.secret.key}")
    private String salt;

    private Key secretKey;

    private final long expiration = 1000L * 60 * 60;

    @Autowired
    private final UserDetailsService userDetailsService;

//    @PostConstruct
//    protected void init(){
//        Keys.hmacShaKeyFor(salt.getBytes(StandardCharsets.UTF_8));
//    }
}
