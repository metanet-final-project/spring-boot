package com.example.finalproject.service;

import com.example.finalproject.domain.Route;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService {

    public ResponseEntity<Route> save(Route route);
    public List<Route> findALL();
    public ResponseEntity<Route> update(Route route);
    public int delete(int id);
    public Route find(int start_id); //출발 터미널로 도착 터미널 조회
}
