package com.example.finalproject.mapper;

import com.example.finalproject.domain.MyRoute;
import com.example.finalproject.domain.Route;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RouteMapper {

    public void save(Route route);
    public List<Route> findALL();
    public void update(Route route);
    public void delete(int id);
    public Route find(int start_id); //출발 터미널로 도착 터미널 조회

}
