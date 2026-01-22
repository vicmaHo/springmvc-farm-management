package com.vich.farm_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vich.farm_management.service.ProductionService;

@Controller
@RequestMapping("/productions")
public class ProductionController {

    @Autowired
    private ProductionService productionService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("productions", productionService.getAllProductions());
        return "productions/productions";
    }

}
