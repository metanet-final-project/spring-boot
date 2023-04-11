package com.example.finalproject.service;

import com.example.finalproject.domain.Bus;

import java.util.List;

public interface BusService {
    public int save(Bus bus);
    public List<Bus> findAll();
    public int update(Bus bus);
    public int delete(int id);
}
