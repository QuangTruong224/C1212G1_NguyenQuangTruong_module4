package com.example.restful_blog.service.impl;

import com.example.restful_blog.model.AppBlog;
import com.example.restful_blog.repository.IAppBlogRepository;
import com.example.restful_blog.service.IAppBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppBlogService implements IAppBlogService {
    @Autowired
    private IAppBlogRepository iAppBlogRepository;

    @Override
    public List<AppBlog> findAll() {
        return iAppBlogRepository.findAll();
    }

    @Override
    public AppBlog save(AppBlog appBlog) {
        return iAppBlogRepository.save(appBlog);
    }


    @Override
    public AppBlog findById(int id) {
        return iAppBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(AppBlog appBlog) {
        iAppBlogRepository.save(appBlog);
    }

    @Override
    public void remove(int id) {
        iAppBlogRepository.deleteById(id);
    }

    @Override
    public List<AppBlog> searchByContent(String name) {
        return this.iAppBlogRepository.searchByContent("%"+name+"%");
    }

    @Override
    public Page<AppBlog> findAllBy(Pageable pageable) {
        return this.iAppBlogRepository.findAll(pageable);
    }


}
