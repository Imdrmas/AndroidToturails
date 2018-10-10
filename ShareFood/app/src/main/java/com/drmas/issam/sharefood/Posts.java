package com.drmas.issam.sharefood;

import java.util.Date;

/**
 * Created by drmas on 01/04/2018.
 */

public class Posts extends PostId{

   public String user_id, image_url, image_thumb, desc;
   public Date timestamp;

    public Posts(String user_id, String image_url, String image_thumb, String desc, Date timestamp) {
        this.user_id = user_id;
        this.image_url = image_url;
        this.image_thumb = image_thumb;
        this.desc = desc;
        this.timestamp = timestamp;
    }

    public Posts(){}

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage_thumb() {
        return image_thumb;
    }

    public void setImage_thumb(String image_thumb) {
        this.image_thumb = image_thumb;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
