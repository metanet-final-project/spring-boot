package com.example.finalproject.controller;

import com.example.finalproject.domain.Schedule;
import com.example.finalproject.dto.ScheduleDTO;
import com.example.finalproject.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequestMapping("/api/schedule")
@RestController
@AllArgsConstructor
public class ScheduleController {

    private ScheduleService scheduleService;

    @GetMapping("/find/{id}/{routeId}")
    public ResponseEntity<ScheduleDTO> findById(@PathVariable int id, @PathVariable int routeId){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("routeId", routeId);
        ScheduleDTO scheduleDTO = scheduleService.findById(map);
        return scheduleDTO != null
                ? new ResponseEntity<>(scheduleDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find/seat/{routeId}")
    public ResponseEntity<List<ScheduleDTO>> findByRouteId(@PathVariable int routeId){

        List<ScheduleDTO> scheduleDTOList = scheduleService.findByRouteId(routeId);
        return scheduleDTOList != null
                ? new ResponseEntity<>(scheduleDTOList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
