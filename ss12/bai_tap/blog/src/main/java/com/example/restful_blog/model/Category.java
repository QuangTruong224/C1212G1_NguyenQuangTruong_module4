package com.example.restful_blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Integer categoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<AppBlog> appBlogList;

    public Category() {
    }

    public List<AppBlog> getAppBlogList() {
        return appBlogList;
    }

    public void setAppBlogList(List<AppBlog> appBlogList) {
        this.appBlogList = appBlogList;
    }

    public Category(List<AppBlog> appBlogList) {
        this.appBlogList = appBlogList;
    }

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
