package com.edu.zucc.model;

public class Brand {
    private int id;
    private String brandName;
    private String introduce;

    public Brand() {
    }

    public Brand(int id, String brandName, String introduce) {
        this.id = id;
        this.brandName = brandName;
        this.introduce = introduce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
