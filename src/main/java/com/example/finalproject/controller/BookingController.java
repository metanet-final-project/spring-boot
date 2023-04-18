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
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingService service;

    @PostMapping("/save")
    public ResponseEntity<String> memberSave(@RequestBody Booking booking){
        return service.memberSave(booking) == 1 ?
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

    @GetMapping("/find-all-DTO")
    public ResponseEntity<List<BookingDTO>> findAllDTO(){
        List<BookingDTO> bookingList = service.findAllDTO();
        return bookingList != null ?
                new ResponseEntity<>(bookingList,HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Booking booking){
        return service.update(booking) ==1 ?
                new ResponseEntity<>("OK",HttpStatus.OK) :
                new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/changeBookingState")
    public ResponseEntity<String> changeBookingState(@RequestBody Booking booking){
        return service.changeBookingState(booking) == 1 ?
                new ResponseEntity<>("ok",HttpStatus.OK) :
                new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
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

    @GetMapping("/find/findByNonMemId/{nonMemberId}")
    public ResponseEntity<List<Booking>> findByNonMemId(@PathVariable int nonMemberId){

        List<Booking> findNonMemList = service.findByNonMemId(nonMemberId);
        return findNonMemList != null
                ? new ResponseEntity<>(findNonMemList,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find/findByNonMemPayId/{nonMemberId}/{payId}")
    public ResponseEntity<List<Booking>> findByNonMemPayId(@PathVariable int nonMemberId, @PathVariable int payId){
        List<Booking> findNonMemPayList = service.findByNonMemPayId(nonMemberId, payId);
        return findNonMemPayList != null
                ? new ResponseEntity<>(findNonMemPayList,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/find/findValidByLoginId/{loginId}")
    public ResponseEntity<List<Booking>> findValidByLoginId(@PathVariable String loginId){

        List<Booking> findValidList = service.findValidByLoginId(loginId);
        return findValidList != null
                ? new ResponseEntity<>(findValidList,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find/findCancelByLoginId/{loginId}")
    public ResponseEntity<List<Booking>> findCancelByLoginId(@PathVariable String loginId){
        List<Booking> findCancelList = service.findCancelByLoginId(loginId);
        return findCancelList != null
                ? new ResponseEntity<>(findCancelList,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
