package com.example.finalproject.service;

import com.example.finalproject.domain.Schedule;
import com.example.finalproject.dto.ScheduleDTO;
import com.example.finalproject.mapper.ScheduleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleMapper scheduleMapper;

    @Override
    public ScheduleDTO findById(HashMap map) {
        return scheduleMapper.findById(map);
    }
}
