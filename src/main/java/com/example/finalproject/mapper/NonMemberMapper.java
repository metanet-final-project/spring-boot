package com.example.finalproject.mapper;

import com.example.finalproject.domain.NonMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NonMemberMapper {
    public void insert(NonMember nonMember);
    public int delete(int id);
    public int update(NonMember nonMember);
    public List<NonMember> getList();
    public int get(NonMember nonMember);
    public NonMember findById(int id);
    public NonMember findByInfo(NonMember nonMember);
}
