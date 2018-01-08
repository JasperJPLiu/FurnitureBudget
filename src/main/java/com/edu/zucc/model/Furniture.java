package com.edu.zucc.model;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public class Furniture {
    private int id;
    private String furniture_type;
    private String furniture_name;
    private String brand;
    private float unit_price;
    private String colour;
    private String other_information;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFurniture_type() {
        return furniture_type;
    }

    public void setFurniture_type(String furniture_type) {
        this.furniture_type = furniture_type;
    }

    public String getFurniture_name() {
        return furniture_name;
    }

    public void setFurniture_name(String furniture_name) {
        this.furniture_name = furniture_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getOther_information() {
        return other_information;
    }

    public void setOther_information(String other_information) {
        this.other_information = other_information;
    }
}
