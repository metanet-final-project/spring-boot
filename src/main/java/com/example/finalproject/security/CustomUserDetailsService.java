package com.example.finalproject.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return memberMapper.findByUserEmail(username)
//                .orElseThrow(()-> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        return null;
    }
}
