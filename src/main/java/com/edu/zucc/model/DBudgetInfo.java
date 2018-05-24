package com.edu.zucc.model;

public class DBudgetInfo extends DBudget{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public DBudgetInfo(DBudget dBudget, String userName) {
        super.setId(dBudget.getId());
        super.setHarea(dBudget.getHarea());
        super.setRoom(dBudget.getRoom());
        super.setHall(dBudget.getHall());
        super.setKitchen(dBudget.getKitchen());
        super.setToilet(dBudget.getToilet());
        super.setBalcony(dBudget.getBalcony());
        super.setProvince(dBudget.getProvince());
        super.setCity(dBudget.getCity());
        super.setHtype(dBudget.getHtype());
        super.setMatfee(dBudget.getMatfee());
        super.setLabfee(dBudget.getLabfee());
        super.setDesfee(dBudget.getDesfee());
        super.setQuafee(dBudget.getQuafee());
        super.setTotalfee(dBudget.getTotalfee());
        super.setUser(dBudget.getUser());

        this.userName = userName;
    }

    public DBudgetInfo() {

    }
}
