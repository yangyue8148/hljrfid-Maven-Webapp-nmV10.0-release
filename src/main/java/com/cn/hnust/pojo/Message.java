package com.cn.hnust.pojo;

public class Message {
    private String mesType;

    private String mesData;

    private String mesName;

    private String mesNote;

    private Integer mesSort;

    private String mesDelflag;

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType == null ? null : mesType.trim();
    }

    public String getMesData() {
        return mesData;
    }

    public void setMesData(String mesData) {
        this.mesData = mesData == null ? null : mesData.trim();
    }

    public String getMesName() {
        return mesName;
    }

    public void setMesName(String mesName) {
        this.mesName = mesName == null ? null : mesName.trim();
    }

    public String getMesNote() {
        return mesNote;
    }

    public void setMesNote(String mesNote) {
        this.mesNote = mesNote == null ? null : mesNote.trim();
    }

    public Integer getMesSort() {
        return mesSort;
    }

    public void setMesSort(Integer mesSort) {
        this.mesSort = mesSort;
    }

    public String getMesDelflag() {
        return mesDelflag;
    }

    public void setMesDelflag(String mesDelflag) {
        this.mesDelflag = mesDelflag == null ? null : mesDelflag.trim();
    }
    public String getMes_Type() {
    	return mesType;
    }
    
    public void setMes_Type(String mesType) {
    	this.mesType = mesType == null ? null : mesType.trim();
    }
    
    public String getMes_Data() {
    	return mesData;
    }
    
    public void setMes_Data(String mesData) {
    	this.mesData = mesData == null ? null : mesData.trim();
    }
    
    public String getMes_Name() {
    	return mesName;
    }
    
    public void setMes_Name(String mesName) {
    	this.mesName = mesName == null ? null : mesName.trim();
    }
    
    public String getMes_Note() {
    	return mesNote;
    }
    
    public void setMes_Note(String mesNote) {
    	this.mesNote = mesNote == null ? null : mesNote.trim();
    }
    
    public Integer getMes_Sort() {
    	return mesSort;
    }
    
    public void setMes_Sort(Integer mesSort) {
    	this.mesSort = mesSort;
    }
    
    public String getMes_Delflag() {
    	return mesDelflag;
    }
    
    public void setMes_Delflag(String mesDelflag) {
    	this.mesDelflag = mesDelflag == null ? null : mesDelflag.trim();
    }
}