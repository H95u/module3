package com.example.case_study.model;

import java.io.InputStream;

public class Account {
    private int id;
    private byte[] image;

    public Account(int id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
