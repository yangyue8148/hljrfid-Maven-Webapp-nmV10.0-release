package com.cn.hnust.pojo;

public class User {
    
    private Integer id;

    private String usercode;

    private String password;
   // 62179
    private String  username;
    
    private String  flagyy;
    
    
    public String getFlagyy() {
        return flagyy;
    }
    public void setFlagyy(String flagyy) {
        this.flagyy = flagyy;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserCode() {
        return usercode;
    }

    public void setUserCode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String UserName) {
        this.username = UserName;
    }
}