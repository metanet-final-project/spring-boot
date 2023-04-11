package com.example.finalproject.controller;

import com.example.finalproject.domain.Age;
import com.example.finalproject.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/age")
public class AgeController {

    @Autowired
    private AgeService service;

    @PostMapping("/save")
    public void save(Age age){
        service.save(age);
    }

    @GetMapping("/find-all")
    public List<Age> findAll(){
        return service.findAll();
    }

    @PutMapping("/update")
    public int update(Age age){
        return service.update(age);
    }
    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable int id){
        return service.delete(id);
    }

}
