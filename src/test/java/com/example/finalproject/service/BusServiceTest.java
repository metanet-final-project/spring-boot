package com.example.finalproject.service;

import com.example.finalproject.domain.Bus;
import com.example.finalproject.domain.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BusServiceTest {

    @Autowired
    private BusService busService;

    @Test
    public void save(){
        Bus bus = new Bus();
        bus.setBusNum("12가1234");
        bus.setCompanyId(1);
        bus.setGrade("test");
        int result = busService.save(bus);
        assertThat(bus.getId()).isNotNull();
        assertThat(result).isGreaterThan(0);

    }

    @Test
    public void findAll(){
        List<Bus> busList = busService.findAll();

        assertThat(busList.size()).isGreaterThan(0);
    }
}
