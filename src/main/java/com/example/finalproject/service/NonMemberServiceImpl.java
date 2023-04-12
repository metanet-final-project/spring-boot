package com.example.finalproject.service;

import com.example.finalproject.domain.NonMember;
import com.example.finalproject.mapper.NonMemberMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonMemberServiceImpl implements  NonMemberService{
    @Setter(onMethod_=@Autowired)
    private NonMemberMapper nonMemberMapper;


    @Override
    public int insert(NonMember nonMember) {
        return nonMemberMapper.insert(nonMember);
    }


    @Override
    public int update(NonMember nonMember) {
        return nonMemberMapper.update(nonMember);
    }
    @Override
    public int delete(int id) {
        return nonMemberMapper.delete(id);
    }

    @Override
    public List<NonMember> getList() {
        return nonMemberMapper.getList();
    }
}