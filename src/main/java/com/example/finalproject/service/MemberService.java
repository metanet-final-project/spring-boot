package com.example.finalproject.service;

import com.example.finalproject.domain.Member;
import com.example.finalproject.dto.LoginRequest;
import com.example.finalproject.dto.LoginResponse;
import com.example.finalproject.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MemberService {
    public LoginResponse login(LoginRequest request) throws Exception;

    public int save(Member member) throws Exception;

    public Member findById(int memberId);

    public int update(Member member);

    public int delete(int memberId);

    public Member findByLoginId(String loginId);

    public List<Member> findAllMember();

    public List<Member> findByName(String name);



}
