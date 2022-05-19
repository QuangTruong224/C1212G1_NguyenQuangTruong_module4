package com.example.cart_product.controller;

import com.example.cart_product.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    @GetMapping("/cart")
    public String goCart(Model model, @SessionAttribute(name = "cart", required = false) CartDto cartDto) {
//        CÓ thể dùng @ModelAltribute(name = "cart") CartDto cartDto
        model.addAttribute("cart", cartDto);
        return "cart";
    }
    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
