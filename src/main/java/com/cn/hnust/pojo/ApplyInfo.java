package com.cn.hnust.pojo;

public class ApplyInfo {
    private String equipId;

    private String applyName;

    private String hostIp;

    private String applyIp;

    private String contacts;

    private String contTel;

    public String getEquipId() {
        return equipId;
    }

    public void setEquipIdId(String equipId) {
        this.equipId = equipId == null ? null : equipId.trim();
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName == null ? null : applyName.trim();
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp == null ? null : hostIp.trim();
    }

    public String getApplyIp() {
        return applyIp;
    }

    public void setApplyIp(String applyIp) {
        this.applyIp = applyIp == null ? null : applyIp.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel == null ? null : contTel.trim();
    }
}