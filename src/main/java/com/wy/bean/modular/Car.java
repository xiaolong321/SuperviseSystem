package com.wy.bean.modular;

/**
 * 汽车信息
 */
public class Car {
    private String id;
    private String carName;
    private String carPrice;
    private String carColor;
    private String launchDate;
    private String carDes;
    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getCarDes() {
        return carDes;
    }

    public void setCarDes(String carDes) {
        this.carDes = carDes;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", carName='" + carName + '\'' +
                ", carPrice='" + carPrice + '\'' +
                ", carColor='" + carColor + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", carDes='" + carDes + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
