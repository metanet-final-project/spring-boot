package com.example.finalproject.service;

import com.example.finalproject.dto.RouteDTO;
import com.example.finalproject.dto.ScheduleDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduleServiceImplTest {

    @Autowired
    private ScheduleService scheduleService;
    @Test
    void findById() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("routeId", 1);
        scheduleService.findById(map);
    }

    @Test
    void findByRouteId() throws ParseException {
        scheduleService.findByRouteId(1,"2023-04-19");
    }

    @Test
    void findAllDTO() {
        scheduleService.findAllDTO();
    }
}