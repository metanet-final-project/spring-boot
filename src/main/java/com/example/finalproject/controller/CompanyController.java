package com.example.finalproject.controller;

import com.example.finalproject.domain.Bus;
import com.example.finalproject.domain.Company;
import com.example.finalproject.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Company company) {

        return companyService.save(company) == 1
                ? new ResponseEntity<>("success", HttpStatus.CREATED)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Company>> findAll() {
        List<Company> companyList = companyService.findAll();
        return companyList != null
                ? new ResponseEntity<>(companyList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Company company) {

        return companyService.update(company) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {

        return companyService.delete(id) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
