package com.codegym.update_music.controller;


import com.codegym.update_music.dto.MusicDto;
import com.codegym.update_music.model.Music;
import com.codegym.update_music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/musics")
    public String list(Model model) {

        model.addAttribute("musicDto", this.musicService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated  MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            musicService.save(music);
            redirectAttributes.addFlashAttribute("messages", "Create successful");
        }
        return "redirect:/musics";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, MusicDto musicDto,Model model) {
//        Music music = new Music();
        BeanUtils.copyProperties(musicService.findById(id),musicDto);
        model.addAttribute("musicDto", musicDto);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated MusicDto musicDto,BindingResult bindingResult ,RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            musicService.save(music);
            redirectAttributes.addFlashAttribute("messages", "Edit successful");
        }
        return "redirect:/musics";
    }
}

