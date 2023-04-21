package com.example.finalproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RouteServiceImplTest {

    @Autowired
    private RouteService routeService;
    @Test
    void findAll() {
        routeService.findAll();
    }

    @Test
    void findAllByStartTerminalId() {
        routeService.findAllByStartTerminalId(1);
    }

    @Test
    void findAllDTO() {
        routeService.findAllDTO();
    }

    @Test
    void find() {
        routeService.find(1);
    }

    @Test
    void findByStartEndPoint() {
        routeService.findByStartEndPoint(1,2);
    }
}