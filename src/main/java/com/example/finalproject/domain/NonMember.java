package com.example.finalproject.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NonMember {
    private Integer id;
    private String phone;
    private Date birth;
    private String birthStr;

}