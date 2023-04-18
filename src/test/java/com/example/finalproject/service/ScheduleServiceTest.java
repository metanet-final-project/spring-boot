package com.example.finalproject.service;

import com.example.finalproject.domain.NonMember;
import com.example.finalproject.dto.BusDTO;
import com.example.finalproject.dto.RouteDTO;
import com.example.finalproject.dto.ScheduleDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ScheduleServiceTest {
    @Autowired
    private ScheduleService scheduleService;


    @Test
    void findById() {
        // given
        int scheduleId = 1;
        int routeId = 1; // assume this is the route ID you want to search for
        int busId =1;
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", scheduleId);
        map.put("routeId", routeId);
        map.put("busId", busId);

        ScheduleDTO result = scheduleService.findById(map);

        assertThat(scheduleId).isEqualTo(result.getId());
    }

    @Test
    void findByRouteId() {
        List<ScheduleDTO> scheduleList = scheduleService.findByRouteId(1, "2023-04-12");
        assertThat(scheduleList).isNotNull();
        assertThat(scheduleList.size()).isGreaterThan(0);
    }
}
