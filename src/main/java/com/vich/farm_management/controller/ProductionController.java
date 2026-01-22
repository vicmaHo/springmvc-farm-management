package com.vich.farm_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vich.farm_management.controller.dto.ProductionUpdateRequest;
import com.vich.farm_management.service.ProductionService;
import com.vich.farm_management.service.ProductionUnitService;
import com.vich.farm_management.service.UnitOfMeasureService;

@Controller
@RequestMapping("/productions")
public class ProductionController {

    @Autowired
    private ProductionService productionService;

    @Autowired
    private UnitOfMeasureService unitOfMeasureService;

    @Autowired
    private ProductionUnitService productionUnitService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("productions", productionService.getAllProductions());
        model.addAttribute("productionUpdateRequest", new ProductionUpdateRequest());
        model.addAttribute("unitOfMeasures", unitOfMeasureService.getAllUnitOfMeasures());
        model.addAttribute("productionUnits", productionUnitService.getAllProductionUnits());
        return "productions/productions";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduction(@PathVariable Integer id) {
        productionService.deleteProduction(id);
        return "redirect:/productions";
    }


    @PostMapping("/edit/{id}")
    public String editProduction(@ModelAttribute ProductionUpdateRequest value, @PathVariable Integer id) {
        productionService.updateProduction(value, id);
        return "redirect:/productions";
    }

}
