package com.example.finalproject.service;

import com.example.finalproject.domain.MyRoute;
import com.example.finalproject.mapper.MyRouteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyRouteServiceImpl implements MyRouteService {

    @Autowired
    private MyRouteMapper myRouteMapper;

    @Override
    public int save(MyRoute myRoute) {
        return myRouteMapper.save(myRoute);
    }

    @Override
    public List<MyRoute> findAll() {
        return myRouteMapper.findAll();
    }

    @Override
    public int update(MyRoute myRoute) {
        return myRouteMapper.update(myRoute);
    }

    @Override
    public int delete(int id) {
        return myRouteMapper.delete(id);
    }

    @Override
    public MyRoute find(int id) {

        return myRouteMapper.find(id);
    }
}
