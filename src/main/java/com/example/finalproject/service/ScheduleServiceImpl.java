package com.example.finalproject.service;

import com.example.finalproject.domain.Schedule;
import com.example.finalproject.dto.RouteDTO;
import com.example.finalproject.dto.ScheduleDTO;
import com.example.finalproject.mapper.ScheduleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    @Override
    public List<ScheduleDTO> findByRouteId(int routeId, String date) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setId(routeId);
        scheduleDTO.setRouteDTO(routeDTO);
        scheduleDTO.setDate(date);
        return scheduleMapper.findByRouteId(scheduleDTO);
    }

    @Override
    @Transactional
    public boolean createDailySchedule() {
        // 현재 날짜 정보
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = sdf.format(date);
//        scheduleMapper.findDaily(dateString); // 하루 스케줄 뽑기
        // 수정 필요
        List<Schedule> scheduleList = scheduleMapper.findAll(); // 전체 정보
        scheduleList.forEach((list) -> {
            Calendar StartTimeCalendar = Calendar.getInstance();
            Calendar endTimeCalendar = Calendar.getInstance();
            StartTimeCalendar.setTime(list.getStartTime());
            endTimeCalendar.setTime(list.getEndTime());

            // Calendar 객체에 하루를 추가 스케줄 결정나면 변경
            StartTimeCalendar.add(Calendar.DAY_OF_MONTH, 1);
            endTimeCalendar.add(Calendar.DAY_OF_MONTH, 1);
            // 변환된 날짜를 Date 객체로 얻기
            Date updateStartTime = StartTimeCalendar.getTime();
            Date updateEndTime = endTimeCalendar.getTime();
            System.out.println(list.toString());
            list.setId(list.getId() + 200);
            list.setStartTime(updateStartTime);
            list.setEndTime(updateEndTime);
            scheduleMapper.save(list);
        });
        return false;
    }

    @Override
    public List<ScheduleDTO> findAllDTO() {
        return scheduleMapper.findAllDTO();
    }

    @Override
    public int save(Schedule schedule) {
        return scheduleMapper.save(schedule);
    }
}
