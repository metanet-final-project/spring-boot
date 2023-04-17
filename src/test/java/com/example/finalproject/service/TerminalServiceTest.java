package com.example.finalproject.service;

import com.example.finalproject.domain.Member;
import com.example.finalproject.domain.NonMember;
import com.example.finalproject.domain.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@SpringBootTest
public class TerminalServiceTest {
    @Autowired
    private TerminalService terminalService;

    @Test
    void save() {
        Terminal terminal = new Terminal();
        terminal.setName("춘천");
        terminal.setLocation("춘천시");
        int result=terminalService.save(terminal);
        assertThat(terminal.getId()).isNotNull();
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void update() {
        Terminal terminal = terminalService.findById(81);
        if (terminal != null) {
            terminal.setName("강릉");
            terminal.setLocation("강원도 강릉시");
            int result = terminalService.update(terminal);
            assertThat(result).isGreaterThan(0);
        } else {
            fail("Terminal not found for updating.");
        }
    }

    @Test
    void delete() {
            assertThat(1).isEqualTo(terminalService.delete(terminalService.findById(142).getId()));
    }

    @Test
    void findById() {
        Terminal terminal = terminalService.findById(70);
        assertNotNull(terminal);
    }

    @Test
    void findAll() {
        List<Terminal> terminalList = terminalService.findAll();
        assertThat(terminalList.size()).isGreaterThan(0);
    }
}
