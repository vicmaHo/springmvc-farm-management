package com.vich.farm_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for login
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        System.out.println("test");
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
    