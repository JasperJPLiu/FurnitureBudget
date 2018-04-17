package com.edu.zucc.model;

public class FurnitureInfo extends Furniture{
    private String typeName;
    private String brandName;

    public FurnitureInfo() {
    }

    public FurnitureInfo(Furniture furniture,String typeName, String brandName) {
        super.setId(furniture.getId());
        super.setFurnitureName(furniture.getFurnitureName());
        super.setFurnitureType(furniture.getFurnitureType());
        super.setBrand(furniture.getBrand());
        super.setUnitPrice(furniture.getUnitPrice());
        super.setColour(furniture.getColour());
        super.setOtherInformation(furniture.getOtherInformation());
        this.typeName = typeName;
        this.brandName = brandName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
