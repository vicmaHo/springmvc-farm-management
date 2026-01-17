package com.vich.farm_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vich.farm_management.service.TransactionService;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "transactions";
    }

    

}
