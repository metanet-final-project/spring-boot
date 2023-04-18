package com.example.finalproject.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pay {
    private int id;
    private String cardNumber;
    private String cardExpiration;
    private int cardPassword;
    private Date birth;
    private int totalPrice;

}
