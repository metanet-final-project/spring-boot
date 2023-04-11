package com.example.finalproject.mapper;

import com.example.finalproject.domain.Bus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusMapper {
    public int save(Bus bus);
    public List<Bus> findAll();
    public int update(Bus bus);
    public int delete(int id);
}
