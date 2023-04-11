package com.example.finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int id;

    private String loginId;

    private String name;

    private String password;

    private String phone;

    private String role;

    private String email;

    private Date birth;
}
