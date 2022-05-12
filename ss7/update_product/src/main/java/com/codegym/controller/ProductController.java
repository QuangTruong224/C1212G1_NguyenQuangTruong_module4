package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    //hiển thị, tìm kiếm
    @GetMapping()
    public String index(@PageableDefault(value = 2, sort = {}) Pageable pageable,
                        @RequestParam Optional<String> name, Model model){
        String nameVal = name.orElse("");
        Page<Product> products = this.iProductService.findByName(nameVal,pageable);
        model.addAttribute("products", products);
        model.addAttribute("nameVal", nameVal);
        return "list";
    }

    //thêm mới
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirect) {
        iProductService.save(product);
        redirect.addFlashAttribute("success", "Add new product successfully!");
        return "redirect:/product";
    }


    //chỉnh sửa
    @GetMapping("/update")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect) {
        iProductService.save(product);
        redirect.addFlashAttribute("success", "Edit product successfully!");
        return "redirect:/product";
    }

    //xóa
    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        iProductService.delete(id);
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    //hiển thị chi tiết
    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }
}
