package com.example.finalproject.controller;

import com.example.finalproject.domain.Schedule;
import com.example.finalproject.dto.ScheduleDTO;
import com.example.finalproject.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/schedule")
@RestController
@AllArgsConstructor
public class ScheduleController {

    private ScheduleService scheduleService;

    @GetMapping("/find")
    public ResponseEntity<List<ScheduleDTO>> findById(@RequestBody Schedule schedule){
        List<ScheduleDTO> scheduleDTOList = scheduleService.findById(schedule);
        return scheduleDTOList != null
                ? new ResponseEntity<>(scheduleDTOList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
