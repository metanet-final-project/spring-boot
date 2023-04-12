package com.example.finalproject.service;

import com.example.finalproject.domain.Bus;
import com.example.finalproject.mapper.BusMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusServiceImpl implements BusService{

    private BusMapper busMapper;

    @Override
    public int save(Bus bus) {
        return busMapper.save(bus);
    }

    @Override
    public List<Bus> findAll() {
        return busMapper.findAll();
    }

    @Override
    public int update(Bus bus) {
        return busMapper.update(bus);
    }

    @Override
    public int delete(int id) {
        return busMapper.delete(id);
    }
}
