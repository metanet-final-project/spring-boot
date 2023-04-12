package com.example.finalproject.mapper;

import com.example.finalproject.domain.NonMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NonMemberMapperTest {

    @Autowired
    private NonMemberMapper nonMemberMapper;

    @Test
    void insert() {
        NonMember non = new NonMember();

    }

    @Test
    void read() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void getList() {
    }
}