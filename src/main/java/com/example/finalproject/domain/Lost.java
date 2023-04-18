package com.example.finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lost {
    private int id;
    private String title;
    private String findPlace;
    private String savePlace;
    private String contents;
    private Date findDate;
    private String fileName;
    private String phone;
}
