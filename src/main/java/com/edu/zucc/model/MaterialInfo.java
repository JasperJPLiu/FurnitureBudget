package com.edu.zucc.model;

public class MaterialInfo extends Material{
    private String brandName;
    private String typeName;

    public MaterialInfo() {
    }

    public MaterialInfo(Material material,String brandName, String typeName) {
        super.setId(material.getId());
        super.setMaterialName(material.getMaterialName());
        super.setUnitPrice(material.getUnitPrice());
        super.setColour(material.getColour());
        super.setOtherInformation(material.getOtherInformation());
        super.setMaterialType(material.getMaterialType());
        super.setBrand(material.getBrand());
        this.brandName = brandName;
        this.typeName = typeName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
