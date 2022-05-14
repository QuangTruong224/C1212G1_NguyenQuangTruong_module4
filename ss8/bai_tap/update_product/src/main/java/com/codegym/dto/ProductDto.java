package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class ProductDto implements Validator {
    Integer id;
    String name;
    @Min(value = 1, message = "Số tiền phải lớn hơn 0")
    Double price;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        ValidationUtils.rejectIfEmpty(errors, "name", "field.empty");
        ValidationUtils.rejectIfEmpty(errors, "description", "field.empty");
        ValidationUtils.rejectIfEmpty(errors, "brand", "field.empty");

        if(!productDto.name.matches("^([\\w]*[\\s]*[\\w]*)+$")){
            errors.rejectValue("name", "field.matches");
        }
        if(!productDto.description.matches("^([\\w]*[\\s]*[\\w]*)+$")){
            errors.rejectValue("description", "field.matches");
        }
        if(!productDto.brand.matches("^([\\w]*[\\s]*[\\w]*)+$")){
            errors.rejectValue("brand", "field.matches");
        }
    }
}
