package com.techelevator.view;

import com.techelevator.VMInventory;
import com.techelevator.VMLog;

public class PurchaseView {
    private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_FINISH_TRANSCATION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT,
            PURCHASE_MENU_FINISH_TRANSCATION};

    private Menu menu;
    private VMInventory inventory;
    private FeedMoneyView feedMoneyView;
    private SelectProductView selectProductView;
    private FinishTransaction finishTransaction;
    private double money;



    public PurchaseView(Menu menu, VMInventory inventory) {
        this.menu = menu;
        this.inventory = inventory;
        this.feedMoneyView = new FeedMoneyView(new Menu(System.in, System.out));
        this.selectProductView = new SelectProductView(new Menu(System.in, System.out), this.inventory);
        this.money = 0;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            if (choice.equals(PURCHASE_MENU_FEED_MONEY)) {
                this.feedMoneyView.setMoney(this.money);
                this.feedMoneyView.run();
                this.money = this.feedMoneyView.getMoney();
            }
            else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
                this.selectProductView.setMoney(this.money);
                this.selectProductView.run();
                this.money = this.selectProductView.getMoney();
            }
            else if (choice.equals(PURCHASE_MENU_FINISH_TRANSCATION)) {
                this.finishTransaction = new FinishTransaction(this.money);
                this.finishTransaction.returnChange();

                int quarters = this.finishTransaction.getQuarters();
                int dimes = this.finishTransaction.getDimes();
                int nickels = this.finishTransaction.getNickels();

                System.out.printf("Balance returned: %d Quarters, %d Dimes, %d Nickels.%n", quarters, dimes, nickels);
                VMLog.log(String.format("GIVE CHANGE: $%.2f $%.2f", this.money, 0.0));

                this.money = 0;
                break;
            }
            
            System.out.printf("Current Balance: $%.2f%n", money);
        }
    }
}
