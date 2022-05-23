package com.example.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @GetMapping("home")
    private String home() {
        return "/home";
    }
//    @RequestMapping(value = "/login")
//    public String loginPage(Model model) {
//
//        return "/loginPage";
//    }
}
