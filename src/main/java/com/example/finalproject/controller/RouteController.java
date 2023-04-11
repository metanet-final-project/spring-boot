package com.example.finalproject.controller;

import com.example.finalproject.domain.Route;
import com.example.finalproject.service.RouteService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@Controller
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public ResponseEntity<List<Route>> findAll(@RequestBody Route route){
        try {
            List<Route> RouteList = routeService.findALL();
            if (RouteList != null) {
                return new ResponseEntity<List<Route>>(RouteList, HttpStatus.OK);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<List<Route>>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Route> save(@RequestBody Route route){
        return routeService.save(route);
    }


    @PutMapping
    public ResponseEntity<Route> update(@RequestBody Route route){
        return routeService.update(route);


    }

    @DeleteMapping
    public ResponseEntity<Integer> delete(@PathVariable int id){
        try {
            int result = routeService.delete(id);
            if(result == 1){
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            }
        }catch (Exception e){
            log.error
        }
    }

    @GetMapping
    public find(){}


}
