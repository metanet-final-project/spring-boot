package com.example.finalproject.service;

import com.example.finalproject.domain.Member;
import com.example.finalproject.dto.LoginRequest;
import com.example.finalproject.dto.LoginResponse;
import com.example.finalproject.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface MemberService {
    LoginResponse login(LoginRequest request) throws Exception;

    int save(Member member) throws Exception;

    Member findById(int memberId);

    int update(Member member);

    int delete(int memberId);

    Member findByLoginId(String loginId);

}
