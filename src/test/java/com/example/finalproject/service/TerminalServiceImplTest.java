package com.example.finalproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TerminalServiceImplTest {

    @Autowired
    private TerminalService terminalService;
    @Test
    void findById() {
        terminalService.findById(1);
    }

    @Test
    void findByName() {
        terminalService.findByName("동서울");
    }

    @Test
    void findAll() {
        terminalService.findAll();
    }
}