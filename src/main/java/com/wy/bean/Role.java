package com.wy.bean;

/**
 * Created by Administrator on 2017/3/2.
 */
public class Role {
    private int role;
    private String roleName;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role=" + role +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
