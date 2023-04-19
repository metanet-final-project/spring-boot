package com.example.finalproject.controller;

import com.example.finalproject.domain.Lost;
import com.example.finalproject.service.LostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lost")
@AllArgsConstructor
public class LostController {

    @Autowired
    private LostService lostService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Lost lost){
        return lostService.save(lost)==1 ?
                new ResponseEntity<>("success", HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Lost>> findAll(){
        List<Lost> lostServiceAll = lostService.findAll();
        return lostServiceAll !=null ?
                new ResponseEntity<>(lostServiceAll,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Lost lost){
        return lostService.update(lost) ==1 ?
                new ResponseEntity<>("success",HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return lostService.delete(id) ==1 ?
                new ResponseEntity<>("success",HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
