package com.example.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayBookingDTO {
    private int id;
    private int cardNumber;
    private String cardExpiration;
    private int cardPassword;
    private Date birth;
    private int totalPrice;
    private List<BookingDTO> bookingDTOList;
}
