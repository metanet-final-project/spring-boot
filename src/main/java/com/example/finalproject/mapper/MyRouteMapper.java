package com.example.finalproject.mapper;

import com.example.finalproject.domain.MyRoute;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyRouteMapper {

    public int save(MyRoute myRoute);
    public List<MyRoute> findAll();
    public int update(MyRoute myRoute);
    public int delete(int id);
    public MyRoute find(int id);
}
