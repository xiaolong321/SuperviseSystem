package com.wy.bean.modular;

/**
 * 费用信息
 */
public class Cost {
    private String id;
    private String costName;
    private String costPrice;
    private String createTime;
    private String costDes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCostDes() {
        return costDes;
    }

    public void setCostDes(String costDes) {
        this.costDes = costDes;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "id='" + id + '\'' +
                ", costName='" + costName + '\'' +
                ", costPrice='" + costPrice + '\'' +
                ", createTime='" + createTime + '\'' +
                ", costDes='" + costDes + '\'' +
                '}';
    }
}
