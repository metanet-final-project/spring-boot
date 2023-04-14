package com.example.finalproject.service;

import com.example.finalproject.domain.Member;
import com.example.finalproject.dto.LoginRequest;
import com.example.finalproject.dto.LoginResponse;
import com.example.finalproject.mapper.MemberMapper;
import com.example.finalproject.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.metadata.ManagedMetric;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public LoginResponse login(LoginRequest request) throws Exception{
        Member loginMember = memberMapper.findByLoginId(request.getLoginId());
        if(loginMember == null || !passwordEncoder.matches(request.getPassword(), loginMember.getPassword())){
            throw new BadCredentialsException("잘못된 로그인 정보입니다.");
        }
        LoginResponse response = new LoginResponse();
        response.setLoginId(loginMember.getLoginId());
        response.setPassword(loginMember.getPassword());

        List<String> roles = new ArrayList<>();
        String[] userRoles = loginMember.getRole().split(",");
        for (String role : userRoles) {
            role = role.toUpperCase().trim();
            if(role != "") roles.add("ROLE_"+role);
        }
        response.setRoles(roles);
        response.setToken(jwtProvider.createToken(loginMember.getLoginId(), roles));
        return response;
    }

    @Override
    public int save(Member member) throws Exception{
        try {
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            member.setRole("MEMBER");
            memberMapper.save(member);

        } catch (Exception e){
            e.getMessage();
            throw new Exception("회원 등록에 실패하였습니다.");

        }
        return 1;
    }

    @Override
    public Member findById(int memberId) {
        return memberMapper.findById(memberId);
    }

    @Override
    public int update(Member member) {
        return memberMapper.update(member);
    }

    @Override
    public int delete(int memberId) {
        return memberMapper.delete(memberId);
    }

    @Override
    public Member findByLoginId(String loginId) {
        return memberMapper.findByLoginId(loginId);
    }

    @Override
    public List<Member> findAllMember() {
        return memberMapper.findAllMember();
    }
}
