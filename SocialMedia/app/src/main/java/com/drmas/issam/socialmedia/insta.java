package com.drmas.issam.socialmedia;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by drmas on 11/03/2018.
 */

public class insta {

    // declaration info user
    private String title,desc,image, img_profile, username, time, comment;

    // Fun Default
    public insta(){}

    // Fun with parameter
    public insta( String title, String desc, String image, String img_profile, String username, String time, String comment) {
        this.title = title;
        this.desc  = desc;
        this.image = image;
        this.time  = time;
        this.username = username;
        this.img_profile = img_profile;
        this.comment = comment;

    }

    // Get username
    public String getUsername() {
        return username;
    }

    // set username
    public void setUsername(String username) {
        this.username = username;
    }

    // get Title post
    public String getTitle() {
        return title;
    }

    // set Title post
    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_profile() {
        return img_profile;
    }

    public void setImg_profile(String img_profile) {
        this.img_profile = img_profile;
    }

    // get Description post
    public String getDesc() {
        return desc;
    }

    // set Description post
    public void setDesc(String desc) {
        this.desc = desc;
    }

    // get image
    public String getImage() {
        return image;
    }

    // set image
    public void setImage(String image) {
        this.image = image;
    }

    // get Time
    public String getTime() {
        return time;
    }

    // Set Time
    public void setTime(String time) {
        this.time = time;
    }

    // Get Comment
    public String getComment() {
        return comment;
    }

    // Set Comment
    public void setComment(String comment) {
        this.comment = comment;
    }
}
