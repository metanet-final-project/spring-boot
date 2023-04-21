package com.example.finalproject.service;
import com.example.finalproject.domain.Company;
import com.example.finalproject.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @BeforeEach
    void initDB(){
        if(memberService.findByLoginId("test") != null){
            memberService.delete(memberService.findByLoginId("test").getId());
        }
    }

    @Test
    void save() throws Exception {
        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("password");
        member.setName("홍길동");
        member.setPhone("010-1234-5678");
        member.setEmail("test@example.com");
        member.setBirth(new Date());
        member.setRole("MEMBER");
        memberService.save(member);
        assertThat("홍길동").isEqualTo(memberService.findByLoginId("test").getName());
    }

    @Test
    void findByLoginId() throws Exception {
        if(memberService.findByLoginId("test") == null){
            this.save();
            assertThat("test@example.com").isEqualTo(memberService.findByLoginId("test").getEmail());
        }else {
            assertThat("test@example.com").isEqualTo(memberService.findByLoginId("test").getEmail());
        }
    }

    @Test
    void update() throws Exception {
        if(memberService.findByLoginId("test") == null){
            this.save();
            Member findMember = memberService.findByLoginId("test");
            findMember.setName("update-name");
            memberService.update(findMember);
            assertThat("update-name").isEqualTo(memberService.findByLoginId("test").getName());
        }else {
            Member findMember = memberService.findByLoginId("test");
            findMember.setName("update-name");
            memberService.update(findMember);
            assertThat("update-name").isEqualTo(memberService.findByLoginId("test").getName());
        }
    }

    @Test
    void delete() throws Exception {
        if(memberService.findByLoginId("test") != null){
            assertThat(1).isEqualTo(memberService.delete(memberService.findByLoginId("test").getId()));
        } else {
            this.save();
            assertThat(1).isEqualTo(memberService.delete(memberService.findByLoginId("test").getId()));
        }

    }

    @Test
    void findAllMember(){
        List<Member> memberList = memberService.findAllMember();

        assertThat(memberList.size()).isGreaterThan(0);
    }


    @Test
    void findByName(){
        Member member = memberService.findById(1);
        memberService.findByName(member.getLoginId());
    }
}
