package com.example.android.hsports;

public class ClothingItem {

    private String itemId;
    private String name;
    private String description;
    private double price;

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description + "\n";
    }

    public double getPrice() {
        return price;
    }

    public ClothingItem(String itemId, String name, String description, double price) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

}
