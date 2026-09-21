package com.example.demo.service;

import com.example.demo.entity.BankEntity;
import com.example.demo.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankEntityService {
    @Autowired
    BankAccountRepository bankAccountRepository;

    public BankEntity createAccount(BankEntity be){
        return bankAccountRepository.save(be);
    }
    public List<BankEntity> getAllAccounts(){
        return bankAccountRepository.findAll();
    }
    public BankEntity getAccount(int id){
        return bankAccountRepository.findById(id).orElse(null);
    }
    public BankEntity updateAccount(BankEntity be){
        return bankAccountRepository.save(be);
    }
    public void deleteAccount(int id){
        bankAccountRepository.deleteById(id);
    }

}
