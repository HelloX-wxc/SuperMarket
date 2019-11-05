package com.qf.bean;

public class SmbillUser {
    private Integer userId;
    private String userName;
    private String userPassword;
    private Integer userGender;
    private Integer userAge;
    private String userTel;
    private String userAddress;
    private Integer userLimited;

    @Override
    public String toString() {
        return "SmbillUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userGender=" + userGender +
                ", userAge=" + userAge +
                ", userTel='" + userTel + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userLimited=" + userLimited +
                '}';
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
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getUserLimited() {
        return userLimited;
    }

    public void setUserLimited(Integer userLimited) {
        this.userLimited = userLimited;
    }

    public SmbillUser(Integer userId, String userName, String userPassword, Integer userGender, Integer userAge, String userTel, String userAddress, Integer userLimited) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userTel = userTel;
        this.userAddress = userAddress;
        this.userLimited = userLimited;
    }

    public SmbillUser() {
    }
}
