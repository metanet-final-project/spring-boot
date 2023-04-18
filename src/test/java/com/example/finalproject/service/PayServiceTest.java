package com.example.finalproject.service;

import com.example.finalproject.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class PayServiceTest {

    @Autowired
    private PayService payService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private NonMemberService nonMemberService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private AgeService ageService;
    @Autowired
    private RouteService routeService;
    @Test
    void save() {
        PayBookingListDTO payBookingListDTO = new PayBookingListDTO();

        // Pay 객체 생성
        Pay pay = new Pay();
        pay.setCardNumber(33);
        pay.setCardExpiration("33");
        pay.setCardPassword(33);
        pay.setBirth(new Date());
        pay.setTotalPrice(22);
        payBookingListDTO.setPay(pay);

        // Booking 리스트 생성
        Booking booking1 = new Booking();
        booking1.setMemberId(1);
        booking1.setNonMemberId(123);
        booking1.setScheduleId(1);
        booking1.setRouteId(1);
        booking1.setAgeId(1);
        booking1.setSeatNum(1);
        booking1.setState("결제완료");
        booking1.setPrice(450000);

        Booking booking2 = new Booking();
        booking2.setMemberId(1);
        booking2.setNonMemberId(123);
        booking2.setScheduleId(1);
        booking2.setRouteId(1);
        booking2.setAgeId(2);
        booking2.setSeatNum(2);
        booking2.setState("결제완료");
        booking2.setPrice(78000);

        payBookingListDTO.setBookingList(Arrays.asList(booking1, booking2));
        int result = payService.insert(payBookingListDTO);
        assertThat(result).isGreaterThanOrEqualTo(1);
    }

    @Test
    void findById() {
        Pay pay = payService.getById(85);
        assertNotNull(pay);
    }

}
