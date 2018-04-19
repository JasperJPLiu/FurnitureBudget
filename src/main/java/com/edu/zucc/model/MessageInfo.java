package com.edu.zucc.model;

public class MessageInfo extends Messageboard{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MessageInfo(Messageboard messageboard,String userName) {
        super.setId(messageboard.getId());
        super.setTitle(messageboard.getTitle());
        super.setReleaseTime(messageboard.getReleaseTime());
        super.setContent(messageboard.getContent());
        super.setUser(messageboard.getUser());

        this.userName = userName;
    }

    public MessageInfo() {

    }
}
