package com.cn.hnust.pojo;

import java.io.Serializable;

public class ClassInfo implements Serializable {
    private String classid;

    private String className;

    private String classStart;

    private String classEnd;

    private String classId;

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getClassStart() {
        return classStart;
    }

    public void setClassStart(String classStart) {
        this.classStart = classStart == null ? null : classStart.trim();
    }

    public String getClassEnd() {
        return classEnd;
    }

    public void setClassEnd(String classEnd) {
        this.classEnd = classEnd == null ? null : classEnd.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }
}