package com.example.finalproject.controller;

import com.example.finalproject.domain.Bus;
import com.example.finalproject.service.BusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@AllArgsConstructor
public class BusController {

    private BusService busService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Bus bus) {

        return busService.save(bus) == 1
                ? new ResponseEntity<>("success", HttpStatus.CREATED)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Bus>> findAll() {
        List<Bus> busList = busService.findAll();
        return busList != null
                ? new ResponseEntity<>(busList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Bus bus) {

        return busService.update(bus) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {

        return busService.delete(id) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
