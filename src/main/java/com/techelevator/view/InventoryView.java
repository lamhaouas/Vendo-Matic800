package com.techelevator.view;

import com.techelevator.VMInventory;
import com.techelevator.VMItem;

import java.util.List;
import java.util.Map;

public class InventoryView {
    private VMInventory vmInventory;

    private Map<String, List<VMItem>> vmInventoryByType;

    public InventoryView(VMInventory vmInventory) {
        vmInventoryByType = vmInventory.getVMItemsByTypes();
    }

    public void run() {
        System.out.println("\n*** Displaying Vending Machine Items ***");

        String[] types = VMInventory.TYPES;
        for(int i = 0; i < types.length; i++) {
            System.out.println(types[i]);

            List<VMItem> items = vmInventoryByType.get(types[i]);
            for(int j = 0; j < items.size(); j++) {
                if (j == 0) {
                    System.out.printf("%6s %-18s %5s %8s%n", "Slot", "Product", "Price", "Quantity");
                }

                VMItem item = items.get(j);
                System.out.printf("%6s %-18s $%.2f %4d", item.getSlotLocation(), item.getProductName(),
                        item.getPrice(), item.getQuantity());
                if (item.getQuantity() == 0) {
                    System.out.print((" (SOLD OUT)"));
                }
                System.out.println();
            }

            System.out.println();
        }
    }
}
