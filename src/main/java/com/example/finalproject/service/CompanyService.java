package com.example.finalproject.service;

import com.example.finalproject.domain.Company;
import com.example.finalproject.domain.Company;

import java.util.List;

public interface CompanyService {
    public int save(Company company);
    public List<Company> findAll();
    public int update(Company company);
    public int delete(int id);
}
