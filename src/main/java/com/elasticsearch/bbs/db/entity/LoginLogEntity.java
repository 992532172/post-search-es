package com.elasticsearch.bbs.db.entity;

import java.io.Serializable;
import java.util.Date;

public class LoginLogEntity implements Serializable {
    //
    private Integer loginLogId;

    //
    private Integer userId;

    //
    private String ip;

    //
    private Date loginTime;

    private static final long serialVersionUID = 1L;

    public Integer getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(Integer loginLogId) {
        this.loginLogId = loginLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loginLogId=").append(loginLogId);
        sb.append(", userId=").append(userId);
        sb.append(", ip=").append(ip);
        sb.append(", loginTime=").append(loginTime);
        sb.append("]");
        return sb.toString();
    }
}