package com.example.finalproject.service;

import com.example.finalproject.domain.Age;

import java.util.List;

public interface AgeService {
    public void save(Age age);
    public List<Age> findAll();
    public int update(Age age);
    public int delete(int id);

}
