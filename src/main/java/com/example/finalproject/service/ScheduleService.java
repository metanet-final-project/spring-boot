package com.example.finalproject.service;

import com.example.finalproject.domain.Route;
import com.example.finalproject.dto.ScheduleDTO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ScheduleService {
    public ScheduleDTO findById(HashMap map);
    public List<ScheduleDTO> findByRouteId(int routeId, String date);
    public boolean createDailySchedule();
}
