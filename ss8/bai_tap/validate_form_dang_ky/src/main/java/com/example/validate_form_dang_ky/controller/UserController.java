package com.example.validate_form_dang_ky.controller;


import com.example.validate_form_dang_ky.dto.UserDto;
import com.example.validate_form_dang_ky.model.User;
import com.example.validate_form_dang_ky.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/index";
    }

    @PostMapping("/login")
    public String checkValidation(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "/index";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            userService.update(userDto);
            model.addAttribute("user", user);
            redirectAttributes.addFlashAttribute("messages","Thành công !");
            return "/result";
        }
    }
}
