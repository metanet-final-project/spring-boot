package com.example.finalproject.controller;

import com.example.finalproject.domain.Company;
import com.example.finalproject.domain.Terminal;
import com.example.finalproject.service.TerminalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terminal")
@AllArgsConstructor
public class TerminalController {

    private TerminalService terminalService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Terminal terminal) {

        return terminalService.save(terminal) == 1
                ? new ResponseEntity<>("success", HttpStatus.CREATED)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Terminal>> findAll() {
        List<Terminal> terminalList = terminalService.findAll();
        return terminalList != null
                ? new ResponseEntity<>(terminalList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Terminal terminal) {

        return terminalService.update(terminal) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {

        return terminalService.delete(id) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
