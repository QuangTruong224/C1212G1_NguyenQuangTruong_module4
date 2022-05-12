package com.codegym.service;

import com.codegym.model.AppBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAppBlogService {
    List<AppBlog> findAll();

    void  save(AppBlog appBlog);

    AppBlog findById(int id);

    void update( AppBlog appBlog);
    void remove(int id);
   List<AppBlog> searchByContent(String name);
    Page<AppBlog> findAllBy(Pageable pageable);

}
