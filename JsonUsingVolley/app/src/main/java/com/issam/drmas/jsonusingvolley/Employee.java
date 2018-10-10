package com.issam.drmas.jsonusingvolley;

import com.google.gson.annotations.SerializedName;

public class Employee {
    private String firstName;
    private int age;
    private String mail;

    @SerializedName("address")
    private Address mAddress;

    public Employee(String firstName, int age, String mail, Address address) {
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
        mAddress = address;
    }
}
