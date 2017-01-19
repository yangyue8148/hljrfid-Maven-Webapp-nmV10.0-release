package com.cn.hnust.pojo;

public class Sign {
	private String custom_num ;

    private String signin_date;

    private String signin_time;
   
    private String  signout_date;
    
    private String signout_time ;

   

    public String getcustom_num() {
        return custom_num;
    }

    public void setcustom_num(String custom_num) {
        this.custom_num = custom_num == null ? null : custom_num.trim();
    }

    public String getSignin_date() {
        return signin_date;
    }

    public void setSignin_date(String signin_date) {
        this.signin_date = signin_date == null ? null : signin_date.trim();
    }

    public String getSignin_time() {
        return signin_time;
    }

    public void setSignin_time(String signin_time) {
        this.signin_time = signin_time;
    }
    
    public String getSignout_date() {
        return signout_date;
    }

    public void setSignout_date(String signout_date) {
        this.signout_date = signout_date == null ? null : signout_date.trim();
    }

    public String getSignout_time() {
        return signout_time;
    }

    public void setSignout_time(String signout_time) {
        this.signout_time = signout_time;
    }
    
}