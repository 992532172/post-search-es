package com.elasticsearch.bbs.db.entity;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {
    //用户id
    private Integer userId;

    //
    private String userName;

    //
    private String password;

    //用户类型 1:普通会员 2:版块管理员 3:论坛管理员
    private Byte userType;

    //是否被锁定
    private Byte locked;

    //
    private Integer credit;

    //上次登录时间
    private Date lastvisit;

    //上次登录地址
    private String lastip;

    //
    private String avatar;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Date getLastvisit() {
        return lastvisit;
    }

    public void setLastvisit(Date lastvisit) {
        this.lastvisit = lastvisit;
    }

    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip == null ? null : lastip.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", userType=").append(userType);
        sb.append(", locked=").append(locked);
        sb.append(", credit=").append(credit);
        sb.append(", lastvisit=").append(lastvisit);
        sb.append(", lastip=").append(lastip);
        sb.append(", avatar=").append(avatar);
        sb.append("]");
        return sb.toString();
    }
}