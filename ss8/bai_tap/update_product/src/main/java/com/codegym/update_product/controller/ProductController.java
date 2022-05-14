package com.codegym.update_product.controller;

import com.codegym.update_product.dto.ProductDto;
import com.codegym.update_product.model.Product;
import com.codegym.update_product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("/product")
    public String index(@PageableDefault(value = 2, sort = {}) Pageable pageable,
                        @RequestParam Optional<String> name, Model model){
        String nameVal = name.orElse("");
        Page<Product> products = this.iProductService.findByName(nameVal,pageable);
        model.addAttribute("products", products);
        model.addAttribute("nameVal", nameVal);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("productDto", new ProductDto());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            iProductService.save(product);
            redirectAttributes.addFlashAttribute("messages", "Create successful");
        }
        return "redirect:/product";
    }


    @GetMapping("/update")
    public String edit(@RequestParam int id,ProductDto productDto ,Model model) {
        BeanUtils.copyProperties(iProductService.findById(id),productDto);
        model.addAttribute("productDto", productDto);
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute @Validated ProductDto productDto,BindingResult bindingResult ,RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            iProductService.save(product);
            redirectAttributes.addFlashAttribute("messages", "Edit successful");
        }
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        iProductService.delete(id);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }


}
