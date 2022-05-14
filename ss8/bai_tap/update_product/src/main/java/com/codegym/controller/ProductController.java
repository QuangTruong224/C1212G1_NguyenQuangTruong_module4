package com.codegym.controller;

import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;


    @GetMapping()
    public String index(@PageableDefault(value = 2, sort = {}) Pageable pageable,
                        @RequestParam Optional<String> name, Model model){
        String nameVal = name.orElse("");
        Page<Product> products = this.iProductService.findByName(nameVal,pageable);
        model.addAttribute("products", products);
        model.addAttribute("nameVal", nameVal);
        return "list";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("productDto", new ProductDto());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute @Validated ProductDto productDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            iProductService.save(product);
            redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm mới thành công");
            return "redirect:/product";
        }
    }



    @GetMapping("/update")
    public String showUpdateForm(@RequestParam Integer id, ProductDto productDto, Model model) {
        BeanUtils.copyProperties(iProductService.findById(id), productDto);
        model.addAttribute("productDto", productDto);
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute @Validated ProductDto productDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        new ProductDto().validate(productDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "edit";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            iProductService.save(product);
            redirectAttributes.addFlashAttribute("message", "Chỉnh sửa sản phẩm mới thành công");
            return "redirect:/product";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirect) {
        Product product = this.iProductService.findById(id);
        iProductService.delete(id);
        redirect.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/product";
    }

}
