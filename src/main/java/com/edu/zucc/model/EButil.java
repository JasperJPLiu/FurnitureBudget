package com.edu.zucc.model;

/**
 * Created by liujiapeng on 2018/1/3.
 */
public class EButil {
    private String message = "success";
    private int resultCode = 0;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public void Success() {
        message = "success";
        resultCode = 0;
    }

    public void Error(String message) {
        this.message = message;
        resultCode = 1;
    }

    public boolean isSuccess() {
        if (resultCode == 0)
            return true;
        return false;
    }
}
