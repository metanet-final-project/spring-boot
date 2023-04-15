package com.example.finalproject.service;

import com.example.finalproject.domain.Terminal;
import com.example.finalproject.mapper.TerminalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TerminalServiceImpl implements TerminalService{

    private TerminalMapper terminalMapper;

    @Override
    public Terminal findById(int id) {
        return terminalMapper.findById(id);
    }

    @Override
    public int save(Terminal terminal) {
        return terminalMapper.save(terminal);
    }

    @Override
    public List<Terminal> findAll() {
        return terminalMapper.findAll();
    }

    @Override
    public int update(Terminal terminal) {
        return terminalMapper.update(terminal);
    }

    @Override
    public int delete(int id) {
        return terminalMapper.delete(id);
    }
}
