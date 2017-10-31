package com.wy.bean.modular;

/**
 * 客户信息
 */
public class Customer {
    private String id;
    private String customerName;
    private String customerGender;
    private String customerEmail;
    private String customerPhone;
    private String customerDes;
    private String customerRegTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerDes() {
        return customerDes;
    }

    public void setCustomerDes(String customerDes) {
        this.customerDes = customerDes;
    }

    public String getCustomerRegTime() {
        return customerRegTime;
    }

    public void setCustomerRegTime(String customerRegTime) {
        this.customerRegTime = customerRegTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerGender='" + customerGender + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerDes='" + customerDes + '\'' +
                ", customerRegTime='" + customerRegTime + '\'' +
                '}';
    }
}
