package com.controller;

import com.model.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public String list(Model model) {

        model.addAttribute("products", this.productService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product,RedirectAttributes redirectAttributes) {
        this.productService.save(product);
        redirectAttributes.addFlashAttribute("messages","successfully added new");
        return "redirect:/products";
    }
//    @GetMapping("/{id}/delete")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("music", musicService.findById(id));
//        return "/list";
//    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        Product product=this.productService.findById(id);
        this.productService.remove(product);
        redirectAttributes.addFlashAttribute("messages","successful delete");
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product,RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("messages", "Update successful");
        return "redirect:/products";
    }

    @PostMapping("/search")
    public String search(@RequestParam(name = "search") String search, Model model) {
        model.addAttribute("products", productService.searchByName(search));
        return "/list";
    }
}
