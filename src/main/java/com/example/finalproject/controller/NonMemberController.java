package com.example.finalproject.controller;

import com.example.finalproject.domain.NonMember;
import com.example.finalproject.service.NonMemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/non-member")
@RestController
@AllArgsConstructor
public class NonMemberController {
    private NonMemberService nonMemberService;

    @PostMapping(value = "/save")
    public NonMember registerNonMember(@RequestBody NonMember nonMember) {
        return nonMemberService.insert(nonMember);
    }

    @GetMapping(value="/find-all")
    public List<NonMember> getList(){
        return nonMemberService.getList();
    }

//    @PostMapping(value="/update")
//    public NonMember update(@RequestBody NonMember nonMember){
//        return nonMemberService.update(nonMember);
//    }
    @PutMapping(value="/update")
    public ResponseEntity<NonMember> update(@RequestBody NonMember nonMember) {
        NonMember updatedNonMember = nonMemberService.update(nonMember);
        if (updatedNonMember == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedNonMember);
        }
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Integer> delete(@PathVariable int id){
        nonMemberService.delete(id);
        return ResponseEntity.ok(id);
    }


}
