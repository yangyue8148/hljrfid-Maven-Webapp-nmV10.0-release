package com.cn.hnust.pojo;

public class TaskEquip {
    private String equipId;

    private String insState;

    private String insTask;

    private String insDate;

    private String classId;

    private String insTime;

    private String picUrl;

    private String operator;

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId == null ? null : equipId.trim();
    }

    public String getInsState() {
        return insState;
    }

    public void setInsState(String insState) {
        this.insState = insState == null ? null : insState.trim();
    }

    public String getInsTask() {
        return insTask;
    }

    public void setInsTask(String insTask) {
        this.insTask = insTask == null ? null : insTask.trim();
    }

    public String getInsDate() {
        return insDate;
    }

    public void setInsDate(String insDate) {
        this.insDate = insDate == null ? null : insDate.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getInsTime() {
        return insTime;
    }

    public void setInsTime(String insTime) {
        this.insTime = insTime == null ? null : insTime.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}