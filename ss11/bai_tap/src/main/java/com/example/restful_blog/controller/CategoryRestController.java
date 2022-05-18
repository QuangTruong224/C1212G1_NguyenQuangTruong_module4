package com.example.restful_blog.controller;

import com.example.restful_blog.model.AppBlog;
import com.example.restful_blog.model.Category;
import com.example.restful_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category-rest")
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/caterory")
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        List<Category> categorys = iCategoryService.findAll();
        if (categorys.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categorys, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Integer id) {
        Optional<Category> categoryOptional = Optional.ofNullable(iCategoryService.findById(id));
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }
}
