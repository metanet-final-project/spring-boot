package com.example.finalproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AgeServiceImplTest {

    @Autowired
    private AgeService ageService;
    @Test
    void findAll() {
        ageService.findAll();
    }
}