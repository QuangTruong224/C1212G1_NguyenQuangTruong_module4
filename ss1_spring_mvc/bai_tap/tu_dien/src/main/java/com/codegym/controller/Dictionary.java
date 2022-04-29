package com.codegym.controller;

import com.codegym.service.DictionnaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Dictionary {
    @Autowired
    private DictionnaryService dictionnaryService;

    @GetMapping(value = "/")
    public String goDictionary() {
        return "dictionnary";
    }

    @PostMapping(value = "/translate")
    public String convert(@RequestParam String english, Model model) {
        Map<String, String> mapDictionnary = dictionnaryService.mapDictionnary();
        String result = dictionnaryService.translate(english);
        model.addAttribute("vietnamese", result);
        return "dictionnary";

    }
}
