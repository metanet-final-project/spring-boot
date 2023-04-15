package com.example.finalproject.service;

import com.example.finalproject.domain.Booking;
import com.example.finalproject.domain.Pay;
import com.example.finalproject.dto.PayBookingListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PayService {
    public int insert(PayBookingListDTO payBookingListDTO);
    public Pay getById(int id);
}
