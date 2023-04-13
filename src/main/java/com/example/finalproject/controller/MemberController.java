package com.example.finalproject.controller;

import com.example.finalproject.domain.Member;
import com.example.finalproject.dto.LoginRequest;
import com.example.finalproject.dto.LoginResponse;
import com.example.finalproject.security.JwtProvider;
import com.example.finalproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberController {
    
    @Autowired
    private JwtProvider jwtProvider;

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

    @GetMapping("/member/findById/{memberId}")
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

    @GetMapping("/member/findByLoginId/{loginId}")
    public ResponseEntity<Member> findByLoginId(@PathVariable String loginId){
        try {
            Member findMember = memberService.findByLoginId(loginId);
            if(findMember != null){
                return new ResponseEntity<>(findMember, HttpStatus.OK);
            }
        } catch (Exception e){
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
