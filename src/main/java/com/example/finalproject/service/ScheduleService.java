package com.example.finalproject.service;

import com.example.finalproject.dto.ScheduleDTO;

import java.util.HashMap;
import java.util.List;

public interface ScheduleService {
    public ScheduleDTO findById(HashMap map);
    public List<ScheduleDTO> findByRouteId(int routeId);
    public boolean createDailySchedule();
}
