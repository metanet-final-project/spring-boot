package com.example.finalproject.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LoginResponse {
    private String loginId;

    private String password;

    private List<String> roles = new ArrayList<>();

    private String token;
}
