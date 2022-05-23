package com.example.casestudy.dto;

import com.example.casestudy.model.employee.Division;
import com.example.casestudy.model.employee.EducationDegree;
import com.example.casestudy.model.employee.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EmployeeDto {
    private Integer id;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private String name;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private String birthday;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private String idCard;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private Double salary;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    @Pattern(regexp = "(^84|0[3|5|7|8|9])+([0-9]{8})$",message = "Đầu 84 hoặc đầu 0")
    private String phone;

    @Email
    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private String email;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private String address;

    private Division division;
    private EducationDegree educationDegree;
    private Position position;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String birthday, String idCard, Double salary, String phone, String email, String address, Division division, EducationDegree educationDegree, Position position) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.division = division;
        this.educationDegree = educationDegree;
        this.position = position;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
