package com.example.demo.controller;

import com.example.demo.components.BankAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankAccountController {
    @GetMapping("Bank")
    public ResponseEntity<BankAccount> getBankAccount(){
        BankAccount bankAccount=new BankAccount(1,"Ram",1000);
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }
    @GetMapping("{id}/{name}/{amount}")
    public ResponseEntity<BankAccount> getBankAccount(@PathVariable("id") int id,
                                                     @PathVariable("name") String name,
                                                     @PathVariable("amount") int amount){
        BankAccount bankAccount=new BankAccount(id,name,amount);
        return new ResponseEntity<>(bankAccount,HttpStatus.OK);
    }
    @GetMapping("query")
    public ResponseEntity<BankAccount> getBankQuery(@RequestParam("id") int id,
                                                     @RequestParam("name") String name,
                                                     @RequestParam("amount") int amount){
        BankAccount bankAccount=new BankAccount(id,name,amount);
        return new ResponseEntity<>(bankAccount,HttpStatus.OK);
    }
    @PostMapping("create")
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount ba){
        System.out.println(ba.getId()+" "+ba.getName()+" "+ba.getAmount());
        return new ResponseEntity<>(ba, HttpStatus.OK);
    }
}
