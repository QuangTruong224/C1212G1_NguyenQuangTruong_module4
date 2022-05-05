package com.controller;

import com.model.ToKhaiYTe;
import com.service.ToKhaiYTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ToKhaiYTeController {
    @Autowired
    private ToKhaiYTeService toKhaiYTeService;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home", "form", new ToKhaiYTe());
        return modelAndView;
    }

    @PostMapping("/send")
    public String send(@ModelAttribute("form") ToKhaiYTe toKhaiYTe, Model model) {
        toKhaiYTeService.addNewForm(toKhaiYTe);
        List<ToKhaiYTe> toKhaiYTeList = toKhaiYTeService.showList();
        model.addAttribute("message", "Thêm mới thành công");
        model.addAttribute("toKhaiYTeList", toKhaiYTeList);
        return "/list";
    }
}
