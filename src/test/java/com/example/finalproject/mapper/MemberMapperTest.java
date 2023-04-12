package com.example.finalproject.mapper;

import com.example.finalproject.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberMapperTest {
    @Autowired
    private MemberMapper memberMapper;

    @BeforeEach
    void initDB(){
        if(memberMapper.findByLoginId("dev") != null){
            memberMapper.delete(memberMapper.findByLoginId("dev").getId());
        }

    }

    @Test
    void save() {
        Member member = new Member();
        member.setLoginId("dev");
        member.setPassword("1234");
        member.setName("devName");
        member.setPhone("010-xxxx-xxxx");
        member.setEmail("dev@metanet.com");
        member.setBirth(new Date());
        member.setRole("MEMBER");
        memberMapper.save(member);
        assertThat("devName").isEqualTo(memberMapper.findByLoginId("dev").getName());
    }

    @Test
    void findById() {
        if(memberMapper.findByLoginId("dev") == null){
            this.save();
            assertThat("devName").isEqualTo(memberMapper.findByLoginId("dev").getName());
        }
        assertThat("devName").isEqualTo(memberMapper.findByLoginId("dev").getName());
    }

    @Test
    void update() {
        if(memberMapper.findByLoginId("dev") == null){
            this.save();
            Member findMember = memberMapper.findByLoginId("dev");
            findMember.setName("update-name");
            memberMapper.update(findMember);
            assertThat("update-name").isEqualTo(memberMapper.findByLoginId("dev").getName());
        }else {
            Member findMember = memberMapper.findByLoginId("dev");
            findMember.setName("update-name");
            memberMapper.update(findMember);
            assertThat("update-name").isEqualTo(memberMapper.findByLoginId("dev").getName());
        }
    }

    @Test
    void delete() {
        if(memberMapper.findByLoginId("dev") != null){
            assertThat(1).isEqualTo(memberMapper.delete(memberMapper.findByLoginId("dev").getId()));
        } else {
            this.save();
            assertThat(1).isEqualTo(memberMapper.delete(memberMapper.findByLoginId("dev").getId()));
        }

    }

    @Test
    void findByLoginId() {
        if(memberMapper.findByLoginId("dev") == null){
            this.save();
            assertThat("dev@metanet.com").isEqualTo(memberMapper.findByLoginId("dev").getEmail());
        }else {
            assertThat("dev@metanet.com").isEqualTo(memberMapper.findByLoginId("dev").getEmail());
        }

    }
}