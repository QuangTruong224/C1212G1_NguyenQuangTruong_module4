package com.example.restful_blog.repository;

import com.example.restful_blog.model.AppBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAppBlogRepository extends JpaRepository<AppBlog, Integer>, PagingAndSortingRepository<AppBlog,Integer> {


    @Query(value = "select * from app_blog where content like :name", nativeQuery = true)
    List<AppBlog> searchByContent(@Param("name") String name);

    Page<AppBlog> findAll(Pageable pageable);

}