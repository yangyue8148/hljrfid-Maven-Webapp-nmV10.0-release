package com.cn.hnust.pojo;

public class ContactInfo {
    private String contactId;

    private String contactName;

    private String contactTel;

    private String contactType;

    private String sendTime;

    private String sendFreq;

    private String sendFlag;

    private String userDepartment;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId == null ? null : contactId.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }
    public String getContact_Tel() {
    	return contactTel;
    }
    
    public void setContact_Tel(String contactTel) {
    	this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType == null ? null : contactType.trim();
    }
    public String getContact_Type() {
    	return contactType;
    }
    
    public void setContact_Type(String contactType) {
    	this.contactType = contactType == null ? null : contactType.trim();
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }

    public String getSendFreq() {
        return sendFreq;
    }

    public void setSendFreq(String sendFreq) {
        this.sendFreq = sendFreq == null ? null : sendFreq.trim();
    }

    public String getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(String sendFlag) {
        this.sendFlag = sendFlag == null ? null : sendFlag.trim();
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment == null ? null : userDepartment.trim();
    }
}