package com.example.finalproject.mapper;

import com.example.finalproject.domain.Age;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AgeMapperTest {
    @Autowired
    private AgeMapper mapper;

    @Test
    void save() {
        Age age = new Age();
        age.setId(1000);
        age.setName("성인");
        mapper.save(age);
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}