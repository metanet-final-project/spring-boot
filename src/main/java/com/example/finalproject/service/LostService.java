package com.example.finalproject.service;

import com.example.finalproject.domain.Lost;

import java.util.List;

public interface LostService {
    public int save(Lost lost);
    public List<Lost> findAll();
    public int update(Lost lost);
    public int delete(int id);
}
