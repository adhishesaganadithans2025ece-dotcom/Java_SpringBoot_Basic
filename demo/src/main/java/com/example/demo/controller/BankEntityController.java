package com.example.demo.controller;

import com.example.demo.entity.BankEntity;
import com.example.demo.service.BankEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("*/api/bank")
public class BankEntityController {
    private final BankEntityService bankEntityService;

    public BankEntityController(BankEntityService bankEntityService) {
        this.bankEntityService = bankEntityService;
    }

    @PostMapping("/create")
    public ResponseEntity<BankEntity> createAccount(@RequestBody BankEntity be){
        bankEntityService.createAccount(be);
        return new ResponseEntity<>(be, HttpStatus.OK);
    }

    @GetMapping("/getAccounts")
    public ResponseEntity<List<BankEntity>> getAllAccounts(){
        List<BankEntity> accounts=bankEntityService.getAllAccounts();
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }
}
