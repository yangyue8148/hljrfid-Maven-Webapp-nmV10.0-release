package com.cn.hnust.pojo;

public class EquipInfo {
    private String equipId;

    private String responsible;

    private String productId;

    private String equipType;

    private String equipName;

    private String equipSpec;

    private String installLocation;

    private String cabinetPosition;

    private String storageTime;

    private String warrantyPeriod;

    private String supplier;

    private String userDepartment;

    private String contact;

    private String remarks;

    private String flag;

    private String ename;

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId == null ? null : equipId.trim();
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible == null ? null : responsible.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType == null ? null : equipType.trim();
    }
    
    public String getEquip_Type() {
        return equipType;
    }

    public void setEquip_Type(String equipType) {
        this.equipType = equipType == null ? null : equipType.trim();
    }
    

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName == null ? null : equipName.trim();
    }

    public String getEquipSpec() {
        return equipSpec;
    }

    public void setEquipSpec(String equipSpec) {
        this.equipSpec = equipSpec == null ? null : equipSpec.trim();
    }

    public String getInstallLocation() {
        return installLocation;
    }

    public void setInstallLocation(String installLocation) {
        this.installLocation = installLocation == null ? null : installLocation.trim();
    }

    public String getCabinetPosition() {
        return cabinetPosition;
    }

    public void setCabinetPosition(String cabinetPosition) {
        this.cabinetPosition = cabinetPosition == null ? null : cabinetPosition.trim();
    }

    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime == null ? null : storageTime.trim();
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod == null ? null : warrantyPeriod.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment == null ? null : userDepartment.trim();
    }
    public String getUser_Department() {
    	return userDepartment;
    }
    
    public void setUser_Department(String userDepartment) {
    	this.userDepartment = userDepartment == null ? null : userDepartment.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }
}