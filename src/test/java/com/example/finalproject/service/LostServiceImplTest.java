package com.example.finalproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LostServiceImplTest {

    @Autowired
    private LostService lostService;
    @Test
    void findAll() {
        lostService.findAll();
    }

    @Test
    void findById() {
        lostService.findById(1);
    }
}