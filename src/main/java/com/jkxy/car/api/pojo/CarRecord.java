package com.jkxy.car.api.pojo;


public class CarRecord {
    private int id;
    private String carName;
    private String carType;
    private String price;
    private String carSeries;
    private String userName;
    private int stockAccount;
    private int totalAccount;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStockAccount() {
        return stockAccount;
    }

    public void setStockAccount(int stockAccount) {
        this.stockAccount = stockAccount;
    }

    public int getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(int totalAccount) {
        this.totalAccount = totalAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", carType='" + carType + '\'' +
                ", price='" + price + '\'' +
                ", carSeries='" + carSeries + '\'' +
                '}';
    }
}
