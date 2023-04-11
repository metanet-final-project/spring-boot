package com.example.finalproject.service;

import com.example.finalproject.domain.Route;
import com.example.finalproject.mapper.RouteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public ResponseEntity<Route> save(Route route) {
        routeMapper.save(route);
        return null;
    }

    @Override
    public List<Route> findALL() {
        return routeMapper.findALL();
    }

    @Override
    public ResponseEntity<Route> update(Route route) {
        routeMapper.update(route);
        return null;
    }

    @Override
    public int delete(int id) {
        routeMapper.delete(id);
        return id;
    }

    @Override
    public Route find(int start_id) {
        return routeMapper.find(start_id);
    }
}
