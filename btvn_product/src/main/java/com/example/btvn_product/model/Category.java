package com.example.btvn_product.model;

public class Category {
    private int id;
    private String name;
    private int slsp = 0;

    public int getSlsp() {
        return slsp;
    }

    public void setSlsp(int slsp) {
        this.slsp = slsp;
    }

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
