package com.codegym.controller;

import com.codegym.model.AppBlog;
import com.codegym.model.Category;
import com.codegym.service.IAppBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppBlogController {
    @Autowired
    private IAppBlogService iAppBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/blog")
    public String list(Model model) {
        model.addAttribute("blogs", this.iAppBlogService.findAll());
        model.addAttribute("category",this.iCategoryService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new AppBlog());
        model.addAttribute("category", this.iCategoryService.findAll());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute AppBlog appBlog,RedirectAttributes redirectAttributes) {
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
        model.addAttribute("category",iCategoryService.findAll());
        return "/edit";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        model.addAttribute("blogs", iAppBlogService.searchByContent(name));

        return "/list";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute AppBlog appBlog, RedirectAttributes redirectAttributes) {
        this.iAppBlogService.update(appBlog);
        redirectAttributes.addFlashAttribute("messages","succesfully update");
        return "redirect:/blog";
    }
}
