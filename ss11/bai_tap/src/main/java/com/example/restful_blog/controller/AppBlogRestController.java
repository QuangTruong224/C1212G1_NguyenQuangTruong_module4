package com.example.restful_blog.controller;

import com.example.restful_blog.model.AppBlog;
import com.example.restful_blog.service.IAppBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog-rest")

public class AppBlogRestController {
    @Autowired
    private IAppBlogService iAppBlogService;

    @GetMapping("/list")
    public ResponseEntity<Page<AppBlog>> getPageBlog(@PageableDefault(value = 2) Pageable pageable) {
        Page<AppBlog> appBlogs = this.iAppBlogService.findAllBy(pageable);
        if (!appBlogs.hasContent()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appBlogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppBlog> findAppBlogById(@PathVariable Integer id) {
        Optional<AppBlog> optionalAppBlog = Optional.ofNullable(iAppBlogService.findById(id));
        if (!optionalAppBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalAppBlog.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AppBlog> saveAppBlog(@RequestBody AppBlog appBlog) {
        return new ResponseEntity<>(iAppBlogService.save(appBlog), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppBlog> updateAppBlog(@PathVariable Integer id, @RequestBody AppBlog appBlog) {
        AppBlog appBlog1 = iAppBlogService.findById(id);
        if (appBlog1==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        appBlog.setId(appBlog1.getId());
        return new ResponseEntity<>(iAppBlogService.save(appBlog), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AppBlog> deleteAppBlog(@PathVariable Integer id) {
        Optional<AppBlog> optionalAppBlog = Optional.ofNullable(iAppBlogService.findById(id));
        if (!optionalAppBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iAppBlogService.remove(id);
        return new ResponseEntity<>(optionalAppBlog.get(), HttpStatus.NO_CONTENT);
    }

}
