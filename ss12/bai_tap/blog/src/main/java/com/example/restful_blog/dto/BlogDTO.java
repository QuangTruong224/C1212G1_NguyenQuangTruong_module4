package com.example.restful_blog.dto;

import com.example.restful_blog.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BlogDTO {
    private Integer idBlog;
    @NotEmpty
    @NotBlank
    @Size(min = 10, max = 800, message = "number of character is between 1 to 800 character")
    private String nameBlog;

    @NotEmpty
    @NotBlank
    @Size(min = 10,max = 10000, message = "number of character is between 1 to 10000 character")
    private String content;
    private Category category;

    public BlogDTO() {
    }

    public BlogDTO(Integer idBlog, String nameBlog, String content, Category category) {
        this.idBlog = idBlog;
        this.nameBlog = nameBlog;
        this.content = content;
        this.category = category;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
