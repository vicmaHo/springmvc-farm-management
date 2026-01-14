package com.vich.farm_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vich.farm_management.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
