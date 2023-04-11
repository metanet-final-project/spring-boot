package com.example.finalproject.service;

import com.example.finalproject.domain.Company;
import com.example.finalproject.mapper.CompanyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private CompanyMapper companyMapper;

    @Override
    public int save(Company company) {
        return companyMapper.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyMapper.findAll();
    }

    @Override
    public int update(Company company) {
        return companyMapper.update(company);
    }

    @Override
    public int delete(int id) {
        return companyMapper.delete(id);
    }
}
