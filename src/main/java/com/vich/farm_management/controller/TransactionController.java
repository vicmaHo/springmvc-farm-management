package com.vich.farm_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vich.farm_management.controller.dto.TransactionCreateRequest;
import com.vich.farm_management.service.ConceptService;
import com.vich.farm_management.service.ProductionUnitService;
import com.vich.farm_management.service.TransactionService;
import com.vich.farm_management.service.UnitOfMeasureService;


@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ConceptService conceptService;

    @Autowired
    private ProductionUnitService productionUnitService;

    @Autowired
    private UnitOfMeasureService unitOfMeasureService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactionsView());
        model.addAttribute("transactionCreateRequest", new TransactionCreateRequest());
        model.addAttribute("concepts", conceptService.getAllConcepts());
        model.addAttribute("productionUnits", productionUnitService.getAllProductionUnits());
        model.addAttribute("unitOfMeasures", unitOfMeasureService.getAllUnitOfMeasures());
        return "transactions/transactions";
    }


    @PostMapping("/new")
    public String newTransactionProduction(@ModelAttribute TransactionCreateRequest value) {
        transactionService.saveTransaction(value);
        return "redirect:/transactions";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Integer id) {
        System.out.println("Deleting transaction with id: " + id);
        transactionService.deleteTransaction(id);
        return "redirect:/transactions";
    }
    

    

}
