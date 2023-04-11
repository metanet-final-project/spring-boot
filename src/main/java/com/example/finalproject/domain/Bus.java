package com.example.finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Results;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    private int id;

    private String busNum;
    private int companyId;
    private String grade;
}
