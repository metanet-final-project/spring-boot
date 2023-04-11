package com.example.finalproject.mapper;

import com.example.finalproject.domain.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {
    public int save(Company company);
    public List<Company> findAll();
    public int update(Company company);
    public int delete(int id);
}
