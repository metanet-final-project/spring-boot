package com.example.finalproject.dto;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.NonMember;
import com.example.finalproject.domain.Pay;
import lombok.Data;

import java.util.List;

@Data
public class PayBookingNonMemListDTO {
    Pay pay;
    NonMember nonMember;
    List<Booking> bookingList;
}
