package com.example.casestudy.dto;

import com.example.casestudy.model.service.RentType;
import com.example.casestudy.model.service.ServiceType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ServiceDto {
    private Integer idService;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private String nameService;


    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    @Min(value = 1, message = "Số diện tích phải lớn hơn 0")
    private Integer areaService;


    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    @Min(value = 1, message = "Số tiền phải lớn hơn 0")
    private Double costService;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private Integer maxPeopleService;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private String standardRoom;

    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    private String discriptionOtherConvenience;

//    @NotBlank(message = "Không được để rỗng")
//    @Pattern(regexp = "^[1-9]+$",message = "Diện tích  hồ bơi phải là số nguyên dương")
    private Double poolArea;


    @NotBlank(message = "Mời nhập vào, không để khoảng trắng")
    @Pattern(regexp = "^[1-9]+$",message = "Số tầng phải là số nguyên dương")
    private Integer numberOfFloors;


    private RentType rentType;
    private ServiceType serviceType;

    public ServiceDto() {
    }

    public ServiceDto(Integer idService, String nameService, Integer areaService, Double costService, Integer maxPeopleService, String standardRoom, String discriptionOtherConvenience, Double poolArea, Integer numberOfFloors, RentType rentType, ServiceType serviceType) {
        this.idService = idService;
        this.nameService = nameService;
        this.areaService = areaService;
        this.costService = costService;
        this.maxPeopleService = maxPeopleService;
        this.standardRoom = standardRoom;
        this.discriptionOtherConvenience = discriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Integer getAreaService() {
        return areaService;
    }

    public void setAreaService(Integer areaService) {
        this.areaService = areaService;
    }

    public Double getCostService() {
        return costService;
    }

    public void setCostService(Double costService) {
        this.costService = costService;
    }

    public Integer getMaxPeopleService() {
        return maxPeopleService;
    }

    public void setMaxPeopleService(Integer maxPeopleService) {
        this.maxPeopleService = maxPeopleService;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDiscriptionOtherConvenience() {
        return discriptionOtherConvenience;
    }

    public void setDiscriptionOtherConvenience(String discriptionOtherConvenience) {
        this.discriptionOtherConvenience = discriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
