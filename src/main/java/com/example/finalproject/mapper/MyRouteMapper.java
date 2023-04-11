package com.example.finalproject.mapper;

import com.example.finalproject.domain.MyRoute;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyRouteMapper {

    public void save(MyRoute myRoute);
    public List<MyRoute> findALL();
    public void update(MyRoute myRoute);
    public void delete(int id);
    public MyRoute find(int id);
}
