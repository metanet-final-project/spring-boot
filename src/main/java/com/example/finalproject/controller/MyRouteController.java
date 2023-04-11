package com.example.finalproject.controller;

import com.example.finalproject.domain.MyRoute;
import com.example.finalproject.domain.Route;
import com.example.finalproject.service.MyRouteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myroute")
@AllArgsConstructor
public class MyRouteController {

    @Autowired
    private MyRouteService myRouteService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody MyRoute myRoute){

        return myRouteService.save(myRoute) == 1
                ? new ResponseEntity<>("success", HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<MyRoute>>findAll(){
        List<MyRoute> myRouteList = myRouteService.findAll();
        return myRouteList != null
                ? new ResponseEntity<>(myRouteList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody MyRoute myRoute){
        return myRouteService.update(myRoute) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){

        return myRouteService.delete(id) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MyRoute> find(@PathVariable int id){

        MyRoute findRoute = myRouteService.find(id);
        return findRoute != null
                ? new ResponseEntity<>(findRoute, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
