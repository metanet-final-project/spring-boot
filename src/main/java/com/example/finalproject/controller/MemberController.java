package com.example.finalproject.controller;

import com.example.finalproject.domain.Member;
import com.example.finalproject.dto.LoginRequest;
import com.example.finalproject.dto.LoginResponse;
import com.example.finalproject.security.JwtProvider;
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
    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws Exception{
        return new ResponseEntity<>(memberService.login(request), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody Member member)throws Exception{
        return new ResponseEntity<>(memberService.save(member), HttpStatus.OK);
    }

    @GetMapping("/member/find/{memberId}")
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
