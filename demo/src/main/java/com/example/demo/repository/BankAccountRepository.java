package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.BankEntity;

public interface BankAccountRepository extends JpaRepository<BankEntity, Integer> {


}