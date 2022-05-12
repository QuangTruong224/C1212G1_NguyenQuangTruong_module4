package com.codegym.update_music.service;

import com.codegym.update_music.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void  save(AppBlog appBlog);

    AppBlog findById(int id);

    void update( AppBlog appBlog);
    void remove(int id);
    List<AppBlog> searchByContent(String name);
    Page<AppBlog> findAllBy(Pageable pageable);
}
