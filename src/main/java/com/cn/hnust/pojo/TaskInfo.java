package com.cn.hnust.pojo;

public class TaskInfo {
    private String taskId;

    private String date;

    private String classId;

    private String operatorFirst;

    private String operatorSecond;

    private String yearMonth;

    private String status;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getOperatorFirst() {
        return operatorFirst;
    }

    public void setOperatorFirst(String operatorFirst) {
        this.operatorFirst = operatorFirst == null ? null : operatorFirst.trim();
    }

    public String getOperatorSecond() {
        return operatorSecond;
    }

    public void setOperatorSecond(String operatorSecond) {
        this.operatorSecond = operatorSecond == null ? null : operatorSecond.trim();
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth == null ? null : yearMonth.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}