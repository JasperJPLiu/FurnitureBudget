package com.edu.zucc.model;


public class Worker {
    private int id;
    private String workerName;
    private String position;
    private float dailyWage;

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

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(float dailyWage) {
        this.dailyWage = dailyWage;
    }
}
