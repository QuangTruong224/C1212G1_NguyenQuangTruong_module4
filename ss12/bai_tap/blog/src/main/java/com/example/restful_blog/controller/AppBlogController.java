package com.example.restful_blog.controller;


import com.example.restful_blog.model.AppBlog;
import com.example.restful_blog.service.IAppBlogService;
import com.example.restful_blog.service.ICategoryService;
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
public class AppBlogController {
    @Autowired
    private IAppBlogService iAppBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/blog")
    public String list(Model model,
                       @PageableDefault(value = 2, sort = {}) Pageable pageable, @RequestParam(defaultValue = "") String searchName) {
//        String keywordVal = keyword.orElse("");
//        Page<AppBlog>appBlogs= iAppBlogService.findAll(pageable);
        model.addAttribute("blogs",this.iAppBlogService.findAllAndSearch(searchName,pageable));
//        model.addAttribute("blogs", this.iAppBlogService.findAll());

//        model.addAttribute("keywordVal", keywordVal);
//        model.addAttribute("category", this.iCategoryService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new AppBlog());
        model.addAttribute("category", this.iCategoryService.findAll());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute AppBlog appBlog, RedirectAttributes redirectAttributes) {
        this.iAppBlogService.save(appBlog);
        redirectAttributes.addFlashAttribute("messages", "successfully added new");
        return "redirect:/blog";
    }

    //
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        AppBlog appBlog = this.iAppBlogService.findById(id);
        this.iAppBlogService.remove(id);
        redirectAttributes.addFlashAttribute("messages", "succesfully delete");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iAppBlogService.findById(id));
        model.addAttribute("category", iCategoryService.findAll());
        return "/edit";
    }

//    @PostMapping("/search")
//    public String search(@RequestParam("name") String name, Model model) {
//        model.addAttribute("blogs", iAppBlogService.searchByContent(name));
//
//        return "/list";
//    }
    @PostMapping("/update")
    public String update(@ModelAttribute AppBlog appBlog, RedirectAttributes redirectAttributes) {
        this.iAppBlogService.update(appBlog);
        redirectAttributes.addFlashAttribute("messages", "succesfully update");
        return "redirect:/blog";
    }
}
