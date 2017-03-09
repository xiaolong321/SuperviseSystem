package com.wy.bean;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/9.
 */
public class Leave {
    private String id;
    //请假类型
    private String leaveType;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //请假理由
    private String leaveReason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "id='" + id + '\'' +
                ", leaveType='" + leaveType + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", leaveReason='" + leaveReason + '\'' +
                '}';
    }
}
