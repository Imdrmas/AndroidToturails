package com.drmas.issam.newtodoapp;

/**
 * Created by drmas on 04/03/2018.
 */

public class Task {

    private String name, time;

    public Task(String name, String time){
        this.name = name;
        this.time = time;
    }

    public Task(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
