package com.example.casestudy.dto;

import com.example.casestudy.model.customer.CustomerType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto {
    private int id;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private String name;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private String birthday;

//    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private Boolean gender;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    @Pattern(regexp = "^d{9}$",message = "Số CMND phải đúng định dạng 9 số")
    private String idCard;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    @Pattern(regexp = "(^84|0[3|5|7|8|9])+([0-9]{8})$",message = "Đầu 84 hoặc đầu 0")
    private String phone;

    @Email
    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private String email;

//    @NotBlank
    private CustomerType customerType;

    public CustomerDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
