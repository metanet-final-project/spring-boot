package com.example.finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pay {
    private int id;
    private int cardNumber;
    private String cardExpiration;
    private int cardPassword;
    private Date birth;
    private int totalPrice;

}
