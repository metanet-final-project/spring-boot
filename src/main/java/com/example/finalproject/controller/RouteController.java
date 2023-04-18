package com.example.finalproject.controller;

import com.example.finalproject.domain.Route;
import com.example.finalproject.dto.RouteDTO;
import com.example.finalproject.service.RouteService;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/api/route")
@AllArgsConstructor
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Route>> findAll(){
        List<Route> routeList = routeService.findAll();
        return routeList != null
                ? new ResponseEntity<>(routeList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Route route){

        return routeService.save(route) == 1
                ? new ResponseEntity<>("success", HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Route route){
        return routeService.update(route) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){

        return routeService.delete(id) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/find/end-point/{terminalId}")
    public ResponseEntity<List<Route>>find(@PathVariable int terminalId){
        List<Route> endIdList = routeService.find(terminalId);
        return endIdList != null
                ? new ResponseEntity<>(endIdList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/findByEndPoint/{terminalId}")
    public ResponseEntity<List<RouteDTO>>findByEndPoint(@PathVariable int terminalId){
        List<RouteDTO> routeDTOList = routeService.findAllByStartTerminalId(terminalId);
        return routeDTOList != null
                ? new ResponseEntity<>(routeDTOList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("find/start-end/point/{startId}/{endId}")
    public ResponseEntity<Integer> findByStartEndPoint(@PathVariable int startId, @PathVariable int endId){
        Integer id = routeService.findByStartEndPoint(startId, endId);
        return id != null
                ? new ResponseEntity<>(id, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
