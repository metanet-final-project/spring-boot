package com.example.finalproject.mapper;

import com.example.finalproject.domain.Age;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AgeMapper {
    public void save(Age age);
    public List<Age> findAll();
    public int update(Age age);
    public int delete(int id);
}
