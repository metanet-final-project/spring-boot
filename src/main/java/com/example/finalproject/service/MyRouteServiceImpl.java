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
    public void save(MyRoute myRoute) {
        myRouteMapper.save(myRoute);
    }

    @Override
    public List<MyRoute> findALL() {
        return myRouteMapper.findALL();
    }

    @Override
    public void update(MyRoute myRoute) {
        myRouteMapper.update(myRoute);
    }

    @Override
    public void delete(int id) {
        myRouteMapper.delete(id);
    }

    @Override
    public MyRoute find(int id) {
        return myRouteMapper.find(id);
    }
}
