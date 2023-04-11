package com.example.finalproject.controller;

import com.example.finalproject.domain.Member;
import com.example.finalproject.security.JwtTokenProvider;
import com.example.finalproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {
    @Autowired
    private final JwtTokenProvider jwtTokenProvider;
    @Autowired
    private final MemberService memberService;

    @PostMapping("/login")
    public String login(@RequestBody Member member){
        log.info("user loginId = {}", member.getLoginId());
        Member loginMember = memberService.findByLoginId(member.getLoginId());
        if(loginMember == null){
            throw new IllegalArgumentException("가입되지 않은 사용자입니다");
        }
        return jwtTokenProvider.createToken(loginMember.getLoginId());
    }

    @GetMapping("/find/{memberId}")
    public ResponseEntity<Member> findById(@PathVariable int memberId){
        try {
            Member findMember = memberService.findById(memberId);
            if(findMember != null){
                return new ResponseEntity<Member>(findMember, HttpStatus.OK);
            }
        } catch (Exception e){
            e.getMessage();
        }
        return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
    }
}
