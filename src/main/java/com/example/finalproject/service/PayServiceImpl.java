package com.example.finalproject.service;

import com.example.finalproject.domain.Pay;
import com.example.finalproject.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements  PayService{
    @Autowired
    private PayMapper payMapper;

    @Override
    public int insert(Pay pay) {
        return payMapper.insert(pay);
    }

    @Override
    public Pay getById(int id) {
        return payMapper.getById(id);
    }
}
