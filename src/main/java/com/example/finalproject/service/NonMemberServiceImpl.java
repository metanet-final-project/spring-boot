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
    public NonMember insert(NonMember nonMember) {
        nonMemberMapper.insert(nonMember);
        return nonMember;
    }


    @Override
    public NonMember update(NonMember nonMember) {
        nonMemberMapper.update(nonMember);
        return nonMember;
    }

    @Override
    public void delete(int id) {
        nonMemberMapper.delete(id);
    }

    @Override
    public List<NonMember> getList() {
        return nonMemberMapper.getList();
    }
}
