package com.example.finalproject.mapper;

import com.example.finalproject.domain.Member;
import com.example.finalproject.domain.Terminal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TerminalMapper {
    public int save(Terminal terminal);
    public List<Terminal> findAll();
    public int update(Terminal terminal);
    public int delete(int id);
    public Terminal findById(int id);
    public List<Terminal> findByName(String name);
}
