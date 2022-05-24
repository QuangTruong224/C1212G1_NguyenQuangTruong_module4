package com.example.casestudy.model.service;

import com.example.casestudy.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")

public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRentType;
    private String rentTypeName;


    public RentType() {
    }
    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    private Set<Service> services;

    public RentType(Integer idRentType, String rentTypeName, Set<Service> services) {
        this.idRentType = idRentType;
        this.rentTypeName = rentTypeName;
        this.services = services;
    }

    public Integer getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(Integer idRentType) {
        this.idRentType = idRentType;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
