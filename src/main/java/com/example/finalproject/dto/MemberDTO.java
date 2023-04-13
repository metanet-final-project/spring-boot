package com.example.finalproject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MemberDTO {
    private int id;
    private String loginID;
    private String name;
    private String password;
    private String phone;
    private String role;
    private String email;
    private Date birth;
}
