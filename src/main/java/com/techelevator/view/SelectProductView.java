package com.techelevator.view;

import com.techelevator.VMInventory;
import com.techelevator.VMItem;
import com.techelevator.VMLog;

import java.util.Scanner;

public class SelectProductView {

    private VMInventory inventory;
    private double money;
    public SelectProductView(Menu menu, VMInventory inventory) {
        this.inventory = inventory;
        this.money = 0.0;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void run() {
        InventoryView inventoryView = new InventoryView(this.inventory);
        inventoryView.run();

        System.out.print("Select the slot location to purchase product: ");
        Scanner input = new Scanner(System.in);

        String slot = null;
        if (input.hasNextLine()) {
            slot = input.nextLine();
        }

        VMItem item = this.inventory.getVMItemBySlotLocation(slot);
        if (item == null) {
            System.out.println("The slot location is invalid.");
            return;
        }

        double price = item.getPrice();
        int quantity = item.getQuantity();

        if (quantity > 0 ) {
            if (price <= this.money) {
                double balanceBefore = this.money;

                this.money -= item.getPrice();
                item.decrementQuantity();
                dispenseItem(item);

                VMLog.log(String.format("%s %s $%.2f $%.2f", item.getProductName(), item.getSlotLocation(), balanceBefore,  this.money));
            }
            else {
                System.out.println("Not enough money to purchase item.");
            }
        }
        else {
            System.out.printf("%s is Sold Out!%n", item.getProductName());
        }
    }

    private void dispenseItem(VMItem item) {
        System.out.printf("%s dispensed.%n", item.getProductName());
        String type = item.getType();
        if (type.equals(VMInventory.TYPE_CHIP)) {
            System.out.println("Crunch Crunch, Yum!");
        }
        else if (type.equals(VMInventory.TYPE_CANDY)) {
            System.out.println("Munch Munch, Yum!");
        }
        else if(type.equals(VMInventory.TYPE_DRINK)) {
            System.out.println("Glug Glug, Yum!");
        }
        else if(type.equals(VMInventory.TYPE_GUM)) {
            System.out.println("Chew Chew, Yum!");
        }
    }
}
