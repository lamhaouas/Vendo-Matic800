package com.techelevator.view;

import com.techelevator.VMLog;

public class FeedMoneyView {
    private static final String FEED_MONEY_ONE_DOLLAR = "$1";
    private static final String FEED_MONEY_TWO_DOLLAR = "$2";
    private static final String FEED_MONEY_FIVE_DOLLAR = "$5";
    private static final String FEED_MONEY_TEN_DOLLAR = "$10";


    private static final String[] FEED_MONEY_OPTIONS = {FEED_MONEY_ONE_DOLLAR, FEED_MONEY_TWO_DOLLAR, FEED_MONEY_FIVE_DOLLAR,
        FEED_MONEY_TEN_DOLLAR};

    private Menu menu;
    private double money;

    public FeedMoneyView(Menu menu) {
        this.menu = menu;
        this.money = 0.0;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void run() {
        double amount = 0.0;

        String choice = (String) this.menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);
        if (choice.equals(FEED_MONEY_ONE_DOLLAR)) {
            amount = 1.00;
        }
        else if (choice.equals(FEED_MONEY_TWO_DOLLAR)) {
            amount = 2.00;
        }
        else if (choice.equals(FEED_MONEY_FIVE_DOLLAR)) {
            amount = 5.00;
        }
        else if (choice.equals(FEED_MONEY_TEN_DOLLAR)) {
            amount = 10.00;
        }

        addMoney(amount);
        VMLog.log(String.format("FEED $%.2f $%.2f", amount, getMoney()));
    }

    private void addMoney(double amount) {
        this.money += amount;
    }
}
