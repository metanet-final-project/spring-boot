package com.example.finalproject.service;

import com.example.finalproject.domain.MyRoute;
import com.example.finalproject.mapper.MyRouteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyRouteService {

    public void save(MyRoute myRoute);
    public List<MyRoute> findALL();
    public void update(MyRoute myRoute);
    public void delete(int id);
    public MyRoute find(int id);

}
