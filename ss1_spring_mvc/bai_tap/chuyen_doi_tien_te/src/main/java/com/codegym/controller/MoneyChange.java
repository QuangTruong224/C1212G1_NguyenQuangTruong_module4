package com.codegym.controller;

import com.codegym.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyChange {
    @Autowired
    private MoneyService moneyService;

    @GetMapping(value = "/goMoney")
    public String goMoney() {
        return "money";
    }

    @PostMapping(value = "/convert")
    public String convert(@RequestParam Double usd,
                          @RequestParam  Double rate,Model model) {
      model.addAttribute("result",this.moneyService.convert(usd,rate));
      return  "result_final";
    }
}
