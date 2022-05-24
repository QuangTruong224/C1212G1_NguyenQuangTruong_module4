package com.example.casestudy.model.contract;

public class AttachService {
    private Integer idAttach;
    private String nameAttach;
    private Double costAttach;
    private Integer unitAttach;
    private String statusAttach;

    public AttachService() {
    }

    public AttachService(Integer idAttach, String nameAttach, Double costAttach, Integer unitAttach, String statusAttach) {
        this.idAttach = idAttach;
        this.nameAttach = nameAttach;
        this.costAttach = costAttach;
        this.unitAttach = unitAttach;
        this.statusAttach = statusAttach;
    }

    public Integer getIdAttach() {
        return idAttach;
    }

    public void setIdAttach(Integer idAttach) {
        this.idAttach = idAttach;
    }

    public String getNameAttach() {
        return nameAttach;
    }

    public void setNameAttach(String nameAttach) {
        this.nameAttach = nameAttach;
    }

    public Double getCostAttach() {
        return costAttach;
    }

    public void setCostAttach(Double costAttach) {
        this.costAttach = costAttach;
    }

    public Integer getUnitAttach() {
        return unitAttach;
    }

    public void setUnitAttach(Integer unitAttach) {
        this.unitAttach = unitAttach;
    }

    public String getStatusAttach() {
        return statusAttach;
    }

    public void setStatusAttach(String statusAttach) {
        this.statusAttach = statusAttach;
    }
}
