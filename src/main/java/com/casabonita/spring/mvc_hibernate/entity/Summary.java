package com.casabonita.spring.mvc_hibernate.entity;

public class Summary {

    private String placeName;
    private String renterName;
    private String contractNumber;
    private String meterNumber;
    private int lastMeterData;
    private String accountNumber;
    private int totalPayments;

    public Summary() {
    }

    public Summary(String placeName, String renterName, String contractNumber, String meterNumber, int lastMeterData, String accountNumber, int totalPayments) {
        this.placeName = placeName;
        this.renterName = renterName;
        this.contractNumber = contractNumber;
        this.meterNumber = meterNumber;
        this.lastMeterData = lastMeterData;
        this.accountNumber = accountNumber;
        this.totalPayments = totalPayments;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public int getLastMeterData() {
        return lastMeterData;
    }

    public void setLastMeterData(int lastMeterData) {
        this.lastMeterData = lastMeterData;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(int totalPayments) {
        this.totalPayments = totalPayments;
    }
}
