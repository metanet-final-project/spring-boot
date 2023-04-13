package com.example.finalproject.mapper;

import com.example.finalproject.domain.Pay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayMapper {
    public int insert(Pay pay);
    public Pay getById(int id);
}
