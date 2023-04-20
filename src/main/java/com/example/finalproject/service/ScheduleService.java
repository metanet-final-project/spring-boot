package com.example.finalproject.service;

import com.example.finalproject.domain.Schedule;
import com.example.finalproject.dto.ScheduleDTO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ScheduleService {
    public ScheduleDTO findById(HashMap map);
    public List<ScheduleDTO> findByRouteId(int routeId, String date);
    public boolean createDailySchedule();
    public List<ScheduleDTO> findAllDTO();
    public int save(Schedule schedule);
    public boolean testSchedule(); // 기본 배차에 2일 배차 추가
}
