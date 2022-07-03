package com.example.Code_Sharing_Platform.PizzaPackage;

public class Pizza {

    private String name;
    private double price;

    // constructor

    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // getters and setters (must be implemented!)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}