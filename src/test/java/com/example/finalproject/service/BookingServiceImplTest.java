package com.example.finalproject.service;

import com.example.finalproject.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingServiceImplTest {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private MemberService memberService;

    @Test
    void findAll() {
        bookingService.findAll();
    }

    @Test
    void findByBookingId() {
        bookingService.findByBookingId(1);
    }

    @Test
    void findTicketByBookingId() {
        bookingService.findTicketByBookingId(1);
    }

    @Test
    void findByNonMemberId() {
        bookingService.findByNonMemPayId(1, 1);
    }

    @Test
    void findSeatByScheduledId() {
        bookingService.findSeatByScheduledId(1);
    }

    @Test
    void findByLoginId() {
        Member member = memberService.findById(1);
        bookingService.findByLoginId(member.getLoginId());
    }

    @Test
    void findValidByLoginId() {
        Member member = memberService.findById(1);
        bookingService.findValidByLoginId(member.getLoginId());
    }

    @Test
    void findByNonMemId() {
        bookingService.findByNonMemId(1);
    }

    @Test
    void findByNonMemPayId() {
        bookingService.findByNonMemPayId(1, 1);
    }

    @Test
    void findCancelByLoginId() {
        Member member = memberService.findById(1);
        bookingService.findCancelByLoginId(member.getLoginId());
    }

    @Test
    void findByPayId() {
        bookingService.findByPayId(1);
    }

    @Test
    void findAllDTO() {
        bookingService.findAllDTO();
    }

    @Test
    void findByPayIdDTO() {
        bookingService.findByPayIdDTO(1);
    }

    @Test
    void findByNonMemberIdToBookingDTO() {
        bookingService.findByNonMemberIdToBookingDTO(1);
    }
}