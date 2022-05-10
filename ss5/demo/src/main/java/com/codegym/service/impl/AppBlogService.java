package com.codegym.service.impl;

import com.codegym.model.AppBlog;
import com.codegym.repository.IAppBlogRepository;
import com.codegym.service.IAppBlogService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(AppBlog appBlog) {
        iAppBlogRepository.save(appBlog);
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


}
