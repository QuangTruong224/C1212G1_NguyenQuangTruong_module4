package com.codegym.repository;

import com.codegym.model.AppBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAppBlogRepository extends JpaRepository<AppBlog, Integer>, PagingAndSortingRepository<AppBlog,Integer> {


    @Query(value = "select * from app_blog where content like :name", nativeQuery = true)
    List<AppBlog> searchByContent(@Param("name") String name);

        Page<AppBlog> findAll(Pageable pageable);

}
