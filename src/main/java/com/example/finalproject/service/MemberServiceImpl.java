package com.example.finalproject.service;

import com.example.finalproject.domain.Member;
import com.example.finalproject.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int save(Member member) throws Exception{
        try {

        } catch (Exception e){

        }
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
}
