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
    public int save(Route route) {
        return routeMapper.save(route);
    }

    @Override
    public List<Route> findAll() {
        return routeMapper.findAll();
    }

    @Override
    public int update(Route route) {
        return routeMapper.update(route);

    }

    @Override
    public int delete(int id) {
        return routeMapper.delete(id);

    }

    @Override
    public List<Route> find(int startId) {
        return routeMapper.find(startId);
    }
}
