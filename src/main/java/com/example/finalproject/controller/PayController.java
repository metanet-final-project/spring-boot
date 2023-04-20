package com.example.finalproject.controller;

import com.example.finalproject.domain.Pay;
import com.example.finalproject.dto.PayBookingDTO;
import com.example.finalproject.dto.PayBookingNonMemListDTO;
import com.example.finalproject.service.PayService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/pay")
public class PayController {
    @Autowired
    private PayService payService;
    @PostMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody PayBookingNonMemListDTO payBookingNonMemListDTO){
        int payId= payService.insert(payBookingNonMemListDTO);
        return payId !=0 ?
                new ResponseEntity<>(payId, HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pay> findByBookingId(@PathVariable int id) {
        Pay pay = payService.getById(id);
        return pay != null ?
                new ResponseEntity<>(pay, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PayBookingDTO>> findAll(){
        List<PayBookingDTO> payBookingList = payService.findAll();
        return payBookingList != null
                ? new ResponseEntity<>(payBookingList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
