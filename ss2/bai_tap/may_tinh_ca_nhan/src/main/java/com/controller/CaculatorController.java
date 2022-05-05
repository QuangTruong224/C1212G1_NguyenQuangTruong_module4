package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.service.CalculateService;


@Controller
public class CaculatorController {
//    CalculateService serviceCalculate=new CalculateServiceImpl();
    @Autowired
    private CalculateService serviceCalculate;

    @RequestMapping("/")
    public String home() {
        return "/home";
    }

    @PostMapping("/caculator")
    public String addition(@RequestParam double first,@RequestParam double second, String calculate, Model model) {

        model.addAttribute("result",this.serviceCalculate.calculate(first,second,calculate));
        return "/home";
    }
}
