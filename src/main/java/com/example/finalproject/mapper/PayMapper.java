package com.example.finalproject.mapper;

import com.example.finalproject.domain.Pay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMapper {
    public int insert(Pay pay);
    public Pay getById(int id);
    public List<Pay> findAll();
}
