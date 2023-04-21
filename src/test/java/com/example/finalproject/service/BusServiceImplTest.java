package com.example.finalproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BusServiceImplTest {


    @Autowired
    private BusService busService;
    @Test
    void findAll() {
        busService.findAll();
    }
}