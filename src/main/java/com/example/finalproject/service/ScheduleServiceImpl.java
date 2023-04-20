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
        try {
            // 현재 날짜 정보
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = sdf.format(date);
            List<Schedule> scheduleList = scheduleMapper.findDaily(dateString); // 하루 스케줄 뽑기

            Calendar StartTimeCalendar = Calendar.getInstance(); // 현재 시간
            Calendar endTimeCalendar = Calendar.getInstance(); // 현재 시간
            scheduleList.forEach((list) -> {
                // 배차시간에 대한 정보로 변경
                StartTimeCalendar.setTime(list.getStartTime());
                endTimeCalendar.setTime(list.getEndTime());

                // 현재 날짜에서 3일 추가
                StartTimeCalendar.add(Calendar.DATE, 3);
                endTimeCalendar.add(Calendar.DATE, 3);

                // 변환된 배차 날짜를 Date 형태로 변경
                Date updateStartTime = StartTimeCalendar.getTime();
                Date updateEndTime = endTimeCalendar.getTime();

                // 배차 객체 정보 변경
                list.setId(list.getId() + 1000);
                list.setStartTime(updateStartTime);
                list.setEndTime(updateEndTime);
                scheduleMapper.save(list);
            });
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
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

    @Override
    @Transactional
    public boolean testSchedule() {  // 기본 배차에 2일 배차 추가
        try {
            // 현재 날짜 정보
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = sdf.format(date);
            List<Schedule> scheduleList = scheduleMapper.findDaily(dateString); // 하루 스케줄 뽑기

            Calendar StartTimeCalendar = Calendar.getInstance(); // 현재 시간
            Calendar endTimeCalendar = Calendar.getInstance(); // 현재 시간

            scheduleList.forEach((list) -> {
                // 배차시간에 대한 정보로 변경
                StartTimeCalendar.setTime(list.getStartTime());
                endTimeCalendar.setTime(list.getEndTime());
                for(int i=1; i<=2; i++) {
                    StartTimeCalendar.add(Calendar.DATE, 1);
                    endTimeCalendar.add(Calendar.DATE, 1);

                    // 변환된 배차 날짜를 Date 형태로 변경
                    Date updateStartTime = StartTimeCalendar.getTime();
                    Date updateEndTime = endTimeCalendar.getTime();

                    // 배차 객체 정보 변경
                    list.setId(list.getId() + 100);
                    list.setStartTime(updateStartTime);
                    list.setEndTime(updateEndTime);
                    scheduleMapper.save(list);
                }

            });
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
