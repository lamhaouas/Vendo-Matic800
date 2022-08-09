package com.techelevator.view;

public class FinishTransaction {
    private double money;
    private int quarters;
    private int dimes;
    private int nickels;

    public FinishTransaction(double money) {
        this.money = money;
    }

    public void returnChange() {
        int cents = (int) (this.money * 100);

        this.quarters = cents / 25;
        int balance = cents % 25;

        this.dimes = balance / 10;
        balance = balance % 10;

        this.nickels = balance / 5;
    }

    public double getMoney() {
        return money;
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }
}
