package com.example.finalproject.service;

import com.example.finalproject.domain.Member;
import com.example.finalproject.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface MemberService {
    int save(Member member);

    Member findById(int memberId);

    int update(Member member);

    int delete(int memberId);

    Member findByLoginId(String loginId);

}
