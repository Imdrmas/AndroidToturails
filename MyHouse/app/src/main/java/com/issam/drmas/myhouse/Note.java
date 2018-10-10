package com.issam.drmas.myhouse;

public class Note {

    private String id;
    private String name;
    private String note;
    private String time;
    private String title;

    public Note (){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Note(String id, String name, String note, String time, String title) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.time = time;
        this.title = title;
    }
}
