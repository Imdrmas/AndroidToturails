package com.drmas.issam.photoblog;

import java.util.Comparator;

/**
 * Created by drmas on 22/03/2018.
 */

public class PostInfo {

    public String username, imgProfile, desc, image, time, comment;

    public PostInfo(){}

    public PostInfo(String username, String imgProfile, String desc, String image, String time, String comment) {
        this.username = username;
        this.imgProfile = imgProfile;
        this.desc = desc;
        this.image = image;
        this.time = time;
        this.comment = comment;
    }


    public String getUserame() {
        return username;
    }

    public void setUserame(String name) {
        this.username = name;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public void setImgProfil(String imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
