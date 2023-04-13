package com.example.finalproject.service;

import com.example.finalproject.domain.Pay;
import org.springframework.stereotype.Service;

@Service
public interface PayService {
    public int insert(Pay pay);
    public Pay getById(int id);
}
