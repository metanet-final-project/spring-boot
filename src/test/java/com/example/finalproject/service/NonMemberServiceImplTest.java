package com.example.finalproject.service;

import com.example.finalproject.domain.NonMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NonMemberServiceImplTest {

    @Autowired
    private NonMemberService nonMemberService;
    @Test
    void getList() {
        nonMemberService.getList();
    }

    @Test
    void findById() {
        nonMemberService.findById(1);
    }

    @Test
    void findByInfo() {
        NonMember nonMember = nonMemberService.findById(1);
        nonMemberService.findByInfo(nonMember);
    }
}