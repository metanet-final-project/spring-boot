package com.example.finalproject.mapper;

import com.example.finalproject.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public int save(Member member);

    public Member findById(int memberId);

    public int update(Member member);

    public int delete(int memberId);

    public Member findByLoginId(String loginId);

}
