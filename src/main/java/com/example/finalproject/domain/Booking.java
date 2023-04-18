package com.example.finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private int id;
    private Integer payId;
    private Integer memberId;
    private Integer nonMemberId;
    private int scheduleId;
    private int routeId;
    private int ageId;
    private int seatNum;
    private String state;
    private int price;

}
