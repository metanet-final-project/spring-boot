package com.example.finalproject.dto;

import lombok.Data;

@Data
public class BusDTO {
    private int id;
    private String busNum;
    private CompanyDTO companyDTO;
    private String grade;
}
