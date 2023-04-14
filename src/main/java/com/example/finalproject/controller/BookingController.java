package com.example.finalproject.controller;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.NonMember;
import com.example.finalproject.dto.BookingDTO;
import com.example.finalproject.service.BookingService;
import com.example.finalproject.service.NonMemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingService service;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Booking booking){
        return service.save(booking) == 1 ?
                new ResponseEntity<>("OK", HttpStatus.CREATED) :
                new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/find-all")
    public ResponseEntity<List<Booking>> findAll(){
        List<Booking> bookingList = service.findAll();
        return bookingList != null ?
                new ResponseEntity<>(bookingList,HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody Booking booking){
        return service.update(booking) ==1 ?
                new ResponseEntity<>("OK",HttpStatus.OK) :
                new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return service.delete(id)==1 ?
                new ResponseEntity<>("OK",HttpStatus.OK):
                new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Booking> findByBookingId(@PathVariable int id) {
        Booking byBookingId = service.findByBookingId(id);
        return byBookingId != null ?
                new ResponseEntity<>(byBookingId, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("find/non-member")
    public ResponseEntity<List<Booking>> findByNonMemberId(NonMember nonMember){
        List<Booking> bookingList = service.findByNonMemberId(nonMember);
        return bookingList != null
                ? new ResponseEntity<>(bookingList,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/find/seat/{scheduleId}")
    public ResponseEntity<List<Booking>> findSeatByScheduledId(@PathVariable int scheduleId){
        List<Booking> bookingList = service.findSeatByScheduledId(scheduleId);
        return bookingList != null
                ? new ResponseEntity<>(bookingList,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find/bypayid/{payId}")
    public ResponseEntity<List<Booking>> findByPayId(@PathVariable int payId){
        List<Booking> bookingListbypay = service.findByPayId(payId);
        return bookingListbypay != null
                ? new ResponseEntity<>(bookingListbypay,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find/findByLoginId/{loginId}")
    public ResponseEntity<List<Booking>> findByLoginId(@PathVariable String loginId){

        List<Booking> findList = service.findByLoginId(loginId);
        return findList != null
                ? new ResponseEntity<>(findList,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
