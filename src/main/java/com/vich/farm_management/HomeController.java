package com.vich.farm_management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String index() {
        System.out.println("test controller");
        return "index";
    }
}
