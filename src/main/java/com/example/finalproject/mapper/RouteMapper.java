package com.example.finalproject.mapper;

import com.example.finalproject.domain.MyRoute;
import com.example.finalproject.domain.Route;
import com.example.finalproject.dto.RouteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RouteMapper {

    public int save(Route route);
    public List<Route> findAll();
    public int update(Route route);
    public int delete(int id);
    public List<Route> find(int startId); //출발 터미널로 도착 터미널 조회

    public List<Route> findAllByStartTerminalId(int startTerminalId);
    public int findByStartEndPoint(Route route);

}
