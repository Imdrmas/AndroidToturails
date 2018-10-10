package com.issam.drmas.myhouse;

public class Users {

    private String userId, name, image;

    public Users(){}

    public Users(String userId, String name, String image) {
        this.name = name;
        this.image = image;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
