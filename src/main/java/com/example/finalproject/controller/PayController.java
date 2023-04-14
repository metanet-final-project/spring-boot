package com.example.finalproject.controller;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.Pay;
import com.example.finalproject.dto.PayBookingListDTO;
import com.example.finalproject.service.PayService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/pay")
public class PayController {
    @Autowired
    private PayService payService;
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody PayBookingListDTO payBookingListDTO){
        System.out.println(payBookingListDTO.getPay().toString());
        System.out.println(payBookingListDTO.getBookingList().toString());
        return payService.insert(payBookingListDTO) == 1 ?
                new ResponseEntity<>("OK", HttpStatus.CREATED) :
                new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pay> findByBookingId(@PathVariable int id) {
        Pay pay = payService.getById(id);
        return pay != null ?
                new ResponseEntity<>(pay, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
