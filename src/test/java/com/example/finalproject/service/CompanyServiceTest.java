package com.example.finalproject.service;

import com.example.finalproject.domain.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CompanyServiceTest {

    @Autowired
   private CompanyService companyService;


    @Test
    public void save(){
        Company company = new Company();
        company.setName("test");
        company.setPhone("010-1234-5678");
        int result = companyService.save(company);
        assertThat(company.getId()).isNotNull();
        assertThat(result).isGreaterThan(0);

    }

    @Test
    public void findAll(){
        List<Company> companyList = companyService.findAll();

        assertThat(companyList.size()).isGreaterThan(0);
    }



}
