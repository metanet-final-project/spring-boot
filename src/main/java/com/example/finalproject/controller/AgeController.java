package com.example.finalproject.controller;

import com.example.finalproject.domain.Age;
import com.example.finalproject.service.AgeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/age")
public class AgeController {

    @Autowired
    private AgeService service;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Age age){
        return service.save(age)==1 ?
                new ResponseEntity<>("OK",HttpStatus.CREATED) :
                new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Age>> findAll(){
        List<Age> ageList = service.findAll();
        return ageList != null ?
                new ResponseEntity<>(ageList, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Age age){
        return service.update(age) == 1 ?
                new ResponseEntity<>("OK",HttpStatus.OK) :
                new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return service.delete(id) ==1 ?
                new ResponseEntity<>("OK",HttpStatus.OK) :
                new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
