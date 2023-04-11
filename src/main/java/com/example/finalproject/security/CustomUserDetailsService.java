package com.example.finalproject.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        MemberVO member = memberService.findByEmail(username);
//        return new User(member.getEmail(), member.getPassword(), getAuthoritiesList(member.getRole()));
        return null;
    }

    private List<SimpleGrantedAuthority> getAuthoritiesList(String roleString){
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        String[] userRoles = roleString.split(",");
        for (String role : userRoles) {
            role = role.toUpperCase().trim();
            if(role != "") authorityList.add(new SimpleGrantedAuthority("ROLE_"+role));
        }
        return authorityList;
    }
}
