package com.techelevator;

public class VMItem {
    private String slotLocation;
    private String productName;
    private double price;
    private String type;
    private int quantity;

    public VMItem(String slotLocation, String productName, double price, String type, int quantity) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decrementQuantity() {
        this.quantity -= 1;
    }
}
