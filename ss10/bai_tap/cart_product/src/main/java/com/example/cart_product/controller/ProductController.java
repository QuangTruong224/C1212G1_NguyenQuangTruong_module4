package com.example.cart_product.controller;

import com.example.cart_product.dto.CartDto;
import com.example.cart_product.dto.ProductDto;
import com.example.cart_product.model.Product;
import com.example.cart_product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SessionAttributes("cart")
@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }


    @GetMapping(value = {"/shop", ""})
    public String goHome(Model model, @PageableDefault(value = 2) Pageable pageable,
                         @RequestParam("sort") Optional<String> sort,
                         @RequestParam Optional<String> name) {
        String searchName = name.orElse("");
        String sortAsc = sort.orElse("");
        model.addAttribute("sort", sortAsc);
        model.addAttribute("products", this.iProductService.findAllAndSearch(searchName, pageable));
        model.addAttribute("search", searchName);
        return "list";
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id,@SessionAttribute("cart") CartDto cartDto){
        Optional<Product> productOptional = iProductService.findById(id);
        if(productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);

            //            THêm product vào  trong session cart
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}


