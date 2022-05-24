package com.example.casestudy.model.service;

import com.example.casestudy.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServiceType;
    private String serviceTypeName;

    public ServiceType() {
    }
    @OneToMany(mappedBy = "serviceType",cascade = CascadeType.ALL)
    private Set<Service> services;

    public ServiceType(Integer idServiceType, String serviceTypeName, Set<Service> services) {
        this.idServiceType = idServiceType;
        this.serviceTypeName = serviceTypeName;
        this.services = services;
    }

    public Integer getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(Integer idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
