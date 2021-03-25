package com.sai.demo.controller;

import com.sai.demo.dal.StringRepo;
import com.sai.demo.model.PalindromeString;
import com.sai.demo.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PalindromeController {

    @Autowired
    StringRepo repo;

    @PostMapping("/addString")
    public PalindromeString inputDesiredString(@RequestBody PalindromeString inputString){
        PalindromeService palindromeService=new PalindromeService();
        String opString = palindromeService.longestPalindrome(inputString.getInputString());
        inputString.setResultString(opString);
        repo.save(inputString);
        return inputString;
    }

    @GetMapping("/getallstrings")
    public List<PalindromeString> getAllResults(){
        return repo.findAll();
    }

    @GetMapping("/string/{id}")
    public Optional<PalindromeString> getString(@PathVariable int id){
        return repo.findById(id);
    }
}
