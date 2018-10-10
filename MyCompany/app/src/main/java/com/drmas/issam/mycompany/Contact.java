package com.drmas.issam.mycompany;

/**
 * Created by drmas on 01/03/2018.
 */

public class Contact {

    private byte[] image;
    private String name;
    private int phone;
    private int id;

    public Contact(String name, int phone, int id, byte[] image) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.image = image;
    }


    public Contact(String name, int phone, int id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
