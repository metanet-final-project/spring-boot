package com.example.finalproject.service;

import com.example.finalproject.domain.NonMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NonMemberService {
    public int insert(NonMember nonMember);
    public int update(NonMember nonMember);
    public int delete(int id);
    public List<NonMember> getList();



}
