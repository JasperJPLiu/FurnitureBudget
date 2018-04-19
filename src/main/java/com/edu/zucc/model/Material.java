package com.edu.zucc.model;

public class Material {
    private int id;
    private int materialType;
    private String materialName;
    private float unitPrice;
    private int brand;
    private String colour;
    private String otherInformation;

    /*区间查找*/
    private float first;
    private float last;

    public float getFirst() {
        return first;
    }

    public void setFirst(float first) {
        this.first = first;
    }

    public float getLast() {
        return last;
    }

    public void setLast(float last) {
        this.last = last;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaterialType() {
        return materialType;
    }

    public void setMaterialType(int materialType) {
        this.materialType = materialType;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }
}
