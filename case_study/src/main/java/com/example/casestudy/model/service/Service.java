package com.example.casestudy.model.service;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idService;
    private String nameService;
    private Integer areaService;
    private Double costService;
    private Integer maxPeopleService;
    private String standardRoom;
    private String discriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;

    public Service() {
    }
    
    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "idRentType")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "idServiceType")
    private ServiceType serviceType;

    public Service(Integer idService, String nameService, Integer areaService, Double costService, Integer maxPeopleService, String standardRoom, String discriptionOtherConvenience, Double poolArea, Integer numberOfFloors, RentType rentType, ServiceType serviceType) {
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
