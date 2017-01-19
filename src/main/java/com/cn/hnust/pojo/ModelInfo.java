package com.cn.hnust.pojo;

public class ModelInfo {
    private String modelId;

    private String modelName;

    private String modelBrand;

    private String modelPic;

    private String remarks;

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getModelBrand() {
        return modelBrand;
    }

    public void setModelBrand(String modelBrand) {
        this.modelBrand = modelBrand == null ? null : modelBrand.trim();
    }

    public String getModelPic() {
        return modelPic;
    }

    public void setModelPic(String modelPic) {
        this.modelPic = modelPic == null ? null : modelPic.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}