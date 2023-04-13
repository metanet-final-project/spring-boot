package com.example.finalproject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PayDTO {
    private int id;
    private int cardNumber;
    private String cardExpiration;
    private int cardPassword;
    private Date birth;
    private int totalPrice;
}
