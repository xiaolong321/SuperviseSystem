package com.wy.bean;

/**
 * Created by Administrator on 2017/2/21.
 */
public class AdminRole {
    private Integer id;
    private String admin_id;
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
                "id=" + id +
                ", admin_id='" + admin_id + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
