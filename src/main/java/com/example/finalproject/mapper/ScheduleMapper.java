package com.example.finalproject.mapper;

import com.example.finalproject.domain.Schedule;
import com.example.finalproject.dto.ScheduleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ScheduleMapper {
    public ScheduleDTO findById(HashMap map);
    public List<ScheduleDTO> findByRouteId(int routeId);
}
