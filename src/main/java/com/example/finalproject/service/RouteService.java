package com.example.finalproject.service;

import com.example.finalproject.domain.Route;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService {

    public int save(Route route);
    public List<Route> findAll();
    public int update(Route route);
    public int delete(int id);
    public List<Route> find(int startId); //출발 터미널로 도착 터미널 조회
}
