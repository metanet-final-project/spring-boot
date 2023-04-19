package com.example.finalproject.mapper;


import com.example.finalproject.domain.Lost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LostMapper {
    public int save(Lost lost);
    public List<Lost> findAll();
    public int update(Lost lost);
    public int delete(int id);
    public Lost findById(int id);
    //public Lost findById(int id);
}
