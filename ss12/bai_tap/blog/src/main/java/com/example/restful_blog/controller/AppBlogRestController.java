package com.example.restful_blog.controller;

import com.example.restful_blog.dto.BlogDTO;
import com.example.restful_blog.model.AppBlog;
import com.example.restful_blog.model.Category;
import com.example.restful_blog.service.IAppBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blog-rest")

public class AppBlogRestController {
    @Autowired
    private IAppBlogService iAppBlogService;

    @GetMapping("/list")
    public ResponseEntity<Page<AppBlog>> getPageBlog( @PageableDefault(value = 10) Pageable pageable, @RequestParam(defaultValue = "") String searchName) {
        Page<AppBlog> appBlogs = this.iAppBlogService.findAllAndSearch(searchName,pageable);
        if (appBlogs.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appBlogs, HttpStatus.OK);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<List<FieldError>> createBlog(@Validated @RequestBody BlogDTO blogDTO,
                                                       BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        AppBlog appBlog = new AppBlog();
        BeanUtils.copyProperties(blogDTO, appBlog);
        this.iAppBlogService.save(appBlog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<FieldError>> saveBlog(@Validated @RequestBody BlogDTO blogDTO,
                                                        BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        AppBlog appBlog = new AppBlog();
        BeanUtils.copyProperties(blogDTO, appBlog);
        this.iAppBlogService.save(appBlog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<List<FieldError>> updateBlog(@RequestParam Integer id, @Validated @RequestBody BlogDTO blogDTO,
                                                       BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        Optional<AppBlog> optionalAppBlog = Optional.ofNullable(iAppBlogService.findById(id));
        if (!optionalAppBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogDTO.setIdBlog(optionalAppBlog.get().getId());
        AppBlog appBlog = new AppBlog();
        BeanUtils.copyProperties(blogDTO, appBlog);
        iAppBlogService.save(appBlog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<AppBlog> updateBlog(@RequestParam Integer id) {
        Optional<AppBlog> optionalAppBlog = Optional.ofNullable(this.iAppBlogService.findById(id));
        if (!optionalAppBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iAppBlogService.remove(id);
        return new ResponseEntity<>(optionalAppBlog.get(), HttpStatus.OK);
    }
//    @GetMapping(value = "/search")
//    public ResponseEntity<List<AppBlog>> searchByContent(@RequestParam String name){
//        return new ResponseEntity<>(iAppBlogService.searchByContent(name), HttpStatus.OK);
//    }

}
