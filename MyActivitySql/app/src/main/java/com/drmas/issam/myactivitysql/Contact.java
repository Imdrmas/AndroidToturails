package com.drmas.issam.myactivitysql;

/**
 * Created by drmas on 05/03/2018.
 */

public class Contact {

    String name, email, username, pass;
 /*
    public Contact(){}

    public Contact(int id, String name, String email, String username, String pass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.pass = pass;
    }
*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
