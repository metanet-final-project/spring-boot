package com.example.finalproject.dto;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.Pay;
import lombok.Data;

import java.util.List;

@Data
public class PayBookingListDTO {
    Pay pay;
    List<Booking> bookingList;
}
