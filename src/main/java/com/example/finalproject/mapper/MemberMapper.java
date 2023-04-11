package com.example.finalproject.mapper;

import com.example.finalproject.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int save(Member member);

    Member findById(int memberId);

    int update(Member member);

    int delete(int memberId);

    Member findByLoginId(String loginId);

}
