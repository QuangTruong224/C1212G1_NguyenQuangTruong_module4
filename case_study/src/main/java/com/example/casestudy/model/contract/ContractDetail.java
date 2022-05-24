package com.example.casestudy.model.contract;

public class ContractDetail {
    private Integer idDetail;
    private Integer idContract;
    private Integer idAttach;
    private Integer quanlity;

    public ContractDetail() {
    }

    public ContractDetail(Integer idDetail, Integer idContract, Integer idAttach, Integer quanlity) {
        this.idDetail = idDetail;
        this.idContract = idContract;
        this.idAttach = idAttach;
        this.quanlity = quanlity;
    }

    public Integer getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(Integer idDetail) {
        this.idDetail = idDetail;
    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public Integer getIdAttach() {
        return idAttach;
    }

    public void setIdAttach(Integer idAttach) {
        this.idAttach = idAttach;
    }

    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer quanlity) {
        this.quanlity = quanlity;
    }
}

