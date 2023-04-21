package com.example.finalproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PayServiceImplTest {

    @Autowired
    private PayService payService;
    @Test
    void getById() {
        payService.getById(1);
    }

    @Test
    void findAll() {
        payService.findAll();
    }

    @Test
    void findByNonMemberId() {
        payService.findByNonMemberId(1);
    }
}