package com.example.finalproject.service;

import com.example.finalproject.domain.Age;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AgeServiceTest {
    @Autowired
    private AgeService ageService;

    @Test
    void save() {
        Age age = new Age();
        age.setName("Age네임111");
        int result = ageService.save(age);

        assertThat(age.getId()).isNotNull();
        assertThat(result).isGreaterThan(0);
    }
    @Test
    void findAll() {
        List<Age> ageList = ageService.findAll();
        assertThat(ageList.size()).isGreaterThan(0);
    }
}
