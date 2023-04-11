package com.example.finalproject.service;

import com.example.finalproject.domain.Age;
import com.example.finalproject.mapper.AgeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgeServiceImpl implements AgeService{

    @Autowired
    private AgeMapper mapper;

    @Override
    public void save(Age age) {
        mapper.save(age);
    }

    @Override
    public List<Age> findAll() {
        return mapper.findAll();
    }

    @Override
    public int update(Age age) {
        mapper.update(age);
        return 0;
    }

    @Override
    public int delete(int id) {
        mapper.delete(id);
        return 0;
    }
}
