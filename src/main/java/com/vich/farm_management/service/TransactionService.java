package com.vich.farm_management.service;

import java.util.List;

import com.vich.farm_management.controller.dto.TransactionCreateRequest;
import com.vich.farm_management.controller.dto.TransactionRequest;
import com.vich.farm_management.controller.dto.TransactionResponse;
import com.vich.farm_management.controller.dto.TransactionView;


public interface TransactionService {

    void saveTransaction(TransactionCreateRequest value);

    List<TransactionResponse> getAllTransactions();

    TransactionResponse getTransactionById(Integer id);

    void updateTransaction(TransactionRequest value, Integer id);

    void deleteTransaction(Integer id);

    List<TransactionView> getAllTransactionsView();
  
}
