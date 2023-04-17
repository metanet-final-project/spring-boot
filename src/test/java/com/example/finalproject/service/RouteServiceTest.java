package com.example.finalproject.service;

import com.example.finalproject.domain.Member;
import com.example.finalproject.domain.Route;
import com.example.finalproject.domain.Terminal;
import com.example.finalproject.dto.RouteDTO;
import com.example.finalproject.dto.TerminalDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@SpringBootTest
public class RouteServiceTest {

    @Autowired
    private RouteService routeService;
    @Autowired
    private TerminalService terminalService;

    @Test
    void save() {
        Terminal startTerminal = terminalService.findById(2);
        Terminal endTerminal = terminalService.findById(2);

        Route route = new Route();
        route.setStartId(startTerminal.getId());
        route.setEndId(endTerminal.getId());
        route.setTravelTime(120);

        // When
        int result = routeService.save(route);

        // Then
        assertThat(route.getId()).isNotNull();
        assertThat(result).isGreaterThan(0);

    }

    @Test
    void update() {
        Terminal startTerminal = terminalService.findById(2);
        Terminal endTerminal = terminalService.findById(2);

        Route route = new Route();
        route.setStartId(startTerminal.getId());
        route.setEndId(endTerminal.getId());
        route.setTravelTime(120);

        int result = routeService.save(route);

        assertThat(route.getId()).isNotNull();
        assertThat(result).isGreaterThan(0);

        route.setTravelTime(180);

        int updateResult = routeService.update(route);

        assertThat(updateResult).isEqualTo(1);
    }

    @Test
    void delete() {
        Terminal startTerminal = terminalService.findById(2);
        Terminal endTerminal = terminalService.findById(2);
        Route route = new Route();
        route.setStartId(startTerminal.getId());
        route.setEndId(endTerminal.getId());
        route.setTravelTime(120);

        int result = routeService.save(route);

        assertThat(route.getId()).isNotNull();
        assertThat(result).isGreaterThan(0);

        int deleteResult = routeService.delete(route.getId());

        assertThat(deleteResult).isEqualTo(1);
    }

    @Test
    void findByStartId() {
        Terminal startTerminal = terminalService.findById(2);
        Terminal endTerminal = terminalService.findById(2);

        Route route1 = new Route();
        route1.setStartId(startTerminal.getId());
        route1.setEndId(endTerminal.getId());
        route1.setTravelTime(120);

        int result1 = routeService.save(route1);

        assertThat(route1.getId()).isNotNull();
        assertThat(result1).isGreaterThan(0);

        Route route2 = new Route();
        route2.setStartId(startTerminal.getId());
        route2.setEndId(endTerminal.getId());
        route2.setTravelTime(180);

        int result2 = routeService.save(route2);

        assertThat(route2.getId()).isNotNull();
        assertThat(result2).isGreaterThan(0);

        List<Route> routes = routeService.find(startTerminal.getId());

    }

    @Test
    void findAll() {
        List<Route> routeList = routeService.findAll();
        assertThat(routeList.size()).isGreaterThan(0);
    }

}
