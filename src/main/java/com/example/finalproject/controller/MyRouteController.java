package com.example.finalproject.controller;

import com.example.finalproject.domain.MyRoute;
import com.example.finalproject.service.MyRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class MyRouteController {

    @Autowired
    private MyRouteService myRouteService;

    @PostMapping
    public save(){}

    @GetMapping
    public findAll(){}

    @PutMapping
    public update(){}

    @DeleteMapping
    public delete(){}

    @GetMapping
    public find(){}

}
