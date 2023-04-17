package com.example.finalproject.service;

import com.example.finalproject.domain.Age;
import com.example.finalproject.domain.Member;
import com.example.finalproject.domain.NonMember;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class NonMemberServiceTest {
    @Autowired
    private NonMemberService nonMemberService;

    @BeforeEach
    void initDB(){
        if(nonMemberService.findByPhone("123456888") != null){
            nonMemberService.delete(nonMemberService.findByPhone("123456888").getId());
        }
    }

    @Test
    void save() {
        NonMember nonMember = new NonMember();
        nonMember.setPhone("123456888");
        nonMember.setBirth(new Date());
        nonMemberService.insert(nonMember);
        assertThat("123456888").isEqualTo(nonMemberService.findByPhone("123456888").getPhone());
    }

    @Test
    void delete() {
        if(nonMemberService.findByPhone("123456888") != null){
            assertThat(1).isEqualTo(nonMemberService.delete(nonMemberService.findByPhone("123456888").getId()));
        } else {
            this.save();
            assertThat(1).isEqualTo(nonMemberService.delete(nonMemberService.findByPhone("123456888").getId()));
        }
    }

    @Test
    void findByPhone() {
        if(nonMemberService.findByPhone("123456888") == null){
            this.save();
            assertThat("123456888").isEqualTo(nonMemberService.findByPhone("123456888").getPhone());
        }else {
            assertThat("123456888").isEqualTo(nonMemberService.findByPhone("123456888").getPhone());
        }
    }

    @Test
    void findAll() {
        List<NonMember> nonMemberList = nonMemberService.getList();
        assertThat(nonMemberList.size()).isGreaterThan(0);
    }





}
