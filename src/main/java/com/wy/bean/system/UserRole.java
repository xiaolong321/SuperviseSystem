package com.wy.bean.system;

/**
 * 账户角色关联表
 */
public class UserRole {
    private int id;
    private String userId;
    private int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
