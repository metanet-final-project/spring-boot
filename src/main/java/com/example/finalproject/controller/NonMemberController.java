package com.example.finalproject.controller;

import com.example.finalproject.domain.NonMember;
import com.example.finalproject.domain.Terminal;
import com.example.finalproject.service.NonMemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/non-member")
@RestController
@AllArgsConstructor
public class NonMemberController {
    private NonMemberService nonMemberService;

    @PostMapping(value = "/save")
    public ResponseEntity<String> save(@RequestBody NonMember nonMember) {
        return nonMemberService.insert(nonMember)==1
                ? new ResponseEntity<>("success", HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value="/find-all")
    public ResponseEntity<List<NonMember>> getList(){
        List<NonMember> nonMemberList = nonMemberService.getList();
        return nonMemberList != null
                ? new ResponseEntity<>(nonMemberList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody NonMember nonMember) {

        return nonMemberService.update(nonMember) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {

        return nonMemberService.delete(id) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
