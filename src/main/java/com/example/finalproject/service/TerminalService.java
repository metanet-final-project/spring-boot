package com.example.finalproject.service;

import com.example.finalproject.domain.Terminal;

import java.util.List;

public interface TerminalService {
    public int save(Terminal terminal);
    public List<Terminal> findAll();
    public int update(Terminal terminal);
    public int delete(int id);
    public Terminal findById(int id);
}
