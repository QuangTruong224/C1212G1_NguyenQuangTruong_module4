package com.example.casestudy.model.contract;

public class Contract {
    private Integer idContract;
    private String startDate;
    private String endDate;
    private String contractDeposit;
    private Double contractTotalMoney;

    public Contract() {
    }

    public Contract(Integer idContract, String startDate, String endDate, String contractDeposit, Double contractTotalMoney) {
        this.idContract = idContract;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }
}
