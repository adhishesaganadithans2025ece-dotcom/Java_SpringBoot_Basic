package com.example.demo.controller;

import com.example.demo.entity.BankEntity;
import com.example.demo.service.BankEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
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
    //http://localhost:8080/api/bank/getAccounts
    @GetMapping("/getAccounts")
    public ResponseEntity<List<BankEntity>> getAllAccounts(){
        List<BankEntity> accounts=bankEntityService.getAllAccounts();
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }
    //http://localhost:8080/api/bank/getAccount/2
    @GetMapping("/getAccount/{id}")
    public ResponseEntity<BankEntity> getAccount(@PathVariable int id){
        BankEntity account=bankEntityService.getAccount(id);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BankEntity> updateAccount(@PathVariable int id,@RequestBody BankEntity be){
        be.setId(id);
        BankEntity account=bankEntityService.updateAccount(be);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }
    //http://localhost:8080/api/bank/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAccount(@PathVariable int id){
        bankEntityService.deleteAccount(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
