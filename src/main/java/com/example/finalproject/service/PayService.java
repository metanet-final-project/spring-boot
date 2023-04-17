package com.example.finalproject.service;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.Pay;
import com.example.finalproject.dto.PayBookingListDTO;
import com.example.finalproject.dto.PayBookingNonMemListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PayService {
    public int insert(PayBookingListDTO payBookingListDTO);
    public int insert(PayBookingNonMemListDTO payBookingNonMemListDTO);
    public Pay getById(int id);
}
