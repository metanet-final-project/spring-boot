package com.example.finalproject.service;

import com.example.finalproject.domain.Pay;
import com.example.finalproject.dto.PayBookingDTO;
import com.example.finalproject.dto.PayBookingNonMemListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PayService {
    //public int insert(PayBookingListDTO payBookingListDTO);
    public int insert(PayBookingNonMemListDTO payBookingNonMemListDTO);
    public Pay getById(int id);
    public List<PayBookingDTO> findAll();
    public int updateTotal(int payId, int bookingId);

}
