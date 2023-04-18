package com.example.finalproject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookingDTO {
    private int id;
    private PayDTO payDTO;
    private MemberDTO memberDTO;
    private NonMemberDTO nonMemberDTO;
    private ScheduleDTO scheduleDTO;
    private RouteDTO routeDTO;
    private AgeDTO ageDTO;
    private int seatNum;
    private String state;
    private int price;

    private Date bookingDate;
}
