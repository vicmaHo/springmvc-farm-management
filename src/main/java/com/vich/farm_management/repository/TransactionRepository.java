package com.vich.farm_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vich.farm_management.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{


    /**
     * Obtain all transactions ordered by date desc
     * @return List of transactions
     */
    List<Transaction> findAllByOrderByDateDesc();
}
