package com.example.finalproject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ScheduleDTO {
    private int id;
    private RouteDTO routeDTO;
    private Date startTime;
    private Date endTime;
    private BusDTO busDTO;
    private int price;
}
