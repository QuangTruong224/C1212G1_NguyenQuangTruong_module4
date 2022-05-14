package com.codegym.update_product.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ProductDto {
    Integer id;

    @NotEmpty(message = "Không được phép để trống")
    @Size(max = 300,message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*)+$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    String name;

    @Min(value = 1, message = "must larger than 0")
    Double price;

    @NotEmpty(message = "Không được phép để trống")
    @Size(max = 1000 ,message = "Không vượt quá 300 ký tự"  )
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*)+$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    String description;
    String brand;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Double price, String description, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
