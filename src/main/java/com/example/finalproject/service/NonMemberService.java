package com.example.finalproject.service;

import com.example.finalproject.domain.NonMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NonMemberService {
    public NonMember insert(NonMember nonMember);
    public NonMember update(NonMember nonMember);
    public void delete(int id);
    public List<NonMember> getList();



}
