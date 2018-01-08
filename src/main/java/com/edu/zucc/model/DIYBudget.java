package com.edu.zucc.model;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public class DIYBudget {
    private int id;
    private String workers;
    private String meterials;
    private int user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkers() {
        return workers;
    }

    public void setWorkers(String workers) {
        this.workers = workers;
    }

    public String getMeterials() {
        return meterials;
    }

    public void setMeterials(String meterials) {
        this.meterials = meterials;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
