package com.edu.zucc.model;

/**
 * Created by liujiapeng on 2018/1/2.
 */
public class Worker {
    private int id;
    private String worker_name;
    private String position;
    private float daily_wage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getDaily_wage() {
        return daily_wage;
    }

    public void setDaily_wage(float daily_wage) {
        this.daily_wage = daily_wage;
    }
}
