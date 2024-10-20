package com.example.btvd;

import java.io.Serializable;

public class Mycontact implements Serializable {
    String name;
    String phone;

    public Mycontact(){

    }

    public Mycontact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Mycontact(int imageID, String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
