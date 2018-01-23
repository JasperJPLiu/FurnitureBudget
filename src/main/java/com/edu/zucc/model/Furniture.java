package com.edu.zucc.model;

public class Furniture {
    private int id;
    private int furnitureType;
    private String furnitureName;
    private int brand;
    private float unitPrice;
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

    public int getFurnitureType() {
        return furnitureType;
    }

    public void setFurnitureType(int furnitureType) {
        this.furnitureType = furnitureType;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
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
