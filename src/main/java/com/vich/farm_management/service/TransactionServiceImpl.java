package com.vich.farm_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vich.farm_management.controller.dto.TransactionCreateRequest;
import com.vich.farm_management.controller.dto.TransactionRequest;
import com.vich.farm_management.controller.dto.TransactionResponse;
import com.vich.farm_management.controller.dto.TransactionView;
import com.vich.farm_management.model.Concept;
import com.vich.farm_management.model.Production;
import com.vich.farm_management.model.ProductionUnit;
import com.vich.farm_management.model.Transaction;
import com.vich.farm_management.model.UnitOfMeasure;
import com.vich.farm_management.repository.ConceptRepository;
import com.vich.farm_management.repository.ProductionRepository;
import com.vich.farm_management.repository.ProductionUnitRepository;
import com.vich.farm_management.repository.TransactionRepository;
import com.vich.farm_management.repository.UnitOfMeasureRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ConceptRepository conceptRepository;

    @Autowired
    private ProductionUnitRepository productionUnitRepository;

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    private ProductionRepository productionRepository;

    /**
     * Save a new transaction
     * 
     * Firtst it checks if the concept and production unit exist
     * then it creates a new Production, saves it, and finally 
     * creates a Transaction and saves it
     * 
     * @param value
     */
    @Override
    public void saveTransaction(TransactionCreateRequest value) {
        
        Concept concept = conceptRepository.findById(value.getConceptId()).orElse(null);
        if (concept == null) {
            throw new IllegalArgumentException("Concept not found with ID: " + value.getConceptId());
        }

        ProductionUnit productionUnit = productionUnitRepository.findById(value.getProductionUnitId()).orElse(null);
        if (productionUnit == null) {
            throw new IllegalArgumentException("ProductionUnit not found with ID: " + value.getProductionUnitId());
        }



        if (value.isCreateProduction()) {
            UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findById(value.getUnitOfMeasureId()).orElse(null);
            if (unitOfMeasure == null) {
                throw new IllegalArgumentException("UnitOfMeasure not found with ID: " + value.getUnitOfMeasureId());
            }
            Production newProduction = new Production();
            newProduction.setDate(value.getDate());
            newProduction.setQuantity(value.getQuantity());
            newProduction.setQuantityCount(value.getQuantityCount());
            newProduction.setNotes(value.getNotes());
            newProduction.setUnitOfMeasure(unitOfMeasure);
            newProduction.setProductionUnit(productionUnit);

            productionRepository.save(newProduction);
        }



        Transaction newTransaction = new Transaction();
        newTransaction.setDate(value.getDate());
        newTransaction.setAmount(value.getAmount());
        newTransaction.setDescription(value.getDescription());
        newTransaction.setConcept(concept);
        newTransaction.setProductionUnit(productionUnit);

        transactionRepository.save(newTransaction);
    }

    @Override
    public List<TransactionResponse> getAllTransactions() {
       
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map(transaction -> {
            TransactionResponse transactionResponse = new TransactionResponse();
            transactionResponse.setId(transaction.getId());
            transactionResponse.setDate(transaction.getDate());
            transactionResponse.setAmount(transaction.getAmount());
            transactionResponse.setDescription(transaction.getDescription());
            transactionResponse.setConceptId(transaction.getConcept().getId());
            transactionResponse.setProductionUnitId(transaction.getProductionUnit().getId());
            return transactionResponse;
        }).toList();
    }

    @Override
    public TransactionResponse getTransactionById(Integer id) {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction not found with ID: " + id);
        }
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setId(transaction.getId());
        transactionResponse.setDate(transaction.getDate());
        transactionResponse.setAmount(transaction.getAmount());
        transactionResponse.setDescription(transaction.getDescription());
        transactionResponse.setConceptId(transaction.getConcept().getId());
        transactionResponse.setProductionUnitId(transaction.getProductionUnit().getId());
        return transactionResponse;
    }

    @Override
    public void updateTransaction(TransactionRequest value, Integer id) {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction not found with ID: " + id);
        }
        transaction.setDate(value.getDate());
        transaction.setAmount(value.getAmount());
        transaction.setDescription(value.getDescription());
        transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public List<TransactionView> getAllTransactionsView() {
        return transactionRepository
                .findAllByOrderByDateDesc()
                .stream()
                .map(t -> TransactionView.builder()
                        .id(t.getId())
                        .date(t.getDate())
                        .amount(t.getAmount())
                        .description(t.getDescription())
                        .conceptName(t.getConcept().getName())
                        .productionUnitName(t.getProductionUnit().getName())
                        .movementTypeName(t.getConcept().getMovementType().getName())
                        .build())
                .toList();
    }

}
