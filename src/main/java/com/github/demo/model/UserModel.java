package com.github.demo.model;

public class UserModel {
    private Integer userId;

    private String userName;

    private String gender;

    private String createTime;

    public UserModel() {}

    public UserModel(Integer userId, String userName, String gender, String createTime) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.createTime = createTime;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}