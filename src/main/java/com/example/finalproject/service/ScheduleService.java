package com.example.finalproject.service;

import com.example.finalproject.domain.Schedule;
import com.example.finalproject.dto.ScheduleDTO;

import java.util.List;

public interface ScheduleService {
    public List<ScheduleDTO> findById(Schedule schedule);
}
