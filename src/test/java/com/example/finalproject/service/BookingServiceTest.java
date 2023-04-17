package com.example.finalproject.service;


import com.example.finalproject.domain.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

   @Test
    void save() {


   }

   @Test
    void findAll(){}

    @Test
    void changeBookingState(){}

    @Test
    void findByBookingId(){}

    @Test
    void findSeatByScheduledId(){}

    @Test
    void findByLoginId(){}

    @Test
    void findByPayId(){}

}
