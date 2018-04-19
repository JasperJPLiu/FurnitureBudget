package com.edu.zucc.model;

public class DIYInfo extends DIYBudget {
    private String userName;
    private String workersName;
    private String meterialsName;
    private float price;

    public String getWorkersName() {
        return workersName;
    }

    public void setWorkersName(String workersName) {
        this.workersName = workersName;
    }

    public String getMeterialsName() {
        return meterialsName;
    }

    public void setMeterialsName(String meterialsName) {
        this.meterialsName = meterialsName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public DIYInfo(DIYBudget diyBudget, String userName, String workersName, String meterialsName, float price) {
        super.setId(diyBudget.getId());
        super.setWorkers(diyBudget.getWorkers());
        super.setMeterials(diyBudget.getMeterials());
        super.setUser(diyBudget.getUser());
        this.userName=userName;
        this.workersName = workersName;
        this.meterialsName = meterialsName;
        this.price=price;
    }

    public DIYInfo() {

    }


}
