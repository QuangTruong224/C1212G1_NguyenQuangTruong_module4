package com.codegym.repository;

import com.codegym.model.AppBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAppBlogRepository extends JpaRepository<AppBlog, Integer> {


    @Query(value = "select * from app_blog where content like :name", nativeQuery = true)

    List<AppBlog> searchByContent(@Param("name") String name);

}
