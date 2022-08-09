package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VMInventory {
    public static final String TYPE_CHIP = "Chip";
    public static final String TYPE_CANDY = "Candy";
    public static final String TYPE_DRINK = "Drink";
    public static final String TYPE_GUM = "Gum";

    public static final String[] TYPES = {TYPE_CHIP, TYPE_CANDY, TYPE_DRINK, TYPE_GUM};

    String fileName;
    private List<VMItem> items;

    public VMInventory(String fileName) {
        this.fileName = fileName;
        this.items = new ArrayList<>();
        loadVendingMachine();
    }

    public List<VMItem> getItems() {
        return items;
    }

    public VMItem getVMItemBySlotLocation(String slotLocation) {
        for(VMItem item : items) {
            if (item.getSlotLocation().equalsIgnoreCase(slotLocation)) {
                return item;
            }
        }
        return null;
    }


    public List<VMItem> getVMItemsByType(String type) {
        List<VMItem> vmItems = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType().equals(type)) {
                vmItems.add(items.get(i));
            }
        }
        return vmItems;
    }

    public Map<String, List<VMItem>> getVMItemsByTypes() {
        Map<String, List<VMItem>> itemsByTypes = new HashMap<>();

        for (int i = 0; i < TYPES.length; i++) {
            String type = TYPES[i];
            itemsByTypes.put(type, getVMItemsByType(type));
        }

        return itemsByTypes;
    }

    private void loadVendingMachine() {
        File file = new File(this.fileName);

        try (Scanner fileInput = new Scanner(file)) {
            while (fileInput.hasNextLine()) {
                String[] inputs = fileInput.nextLine().split("\\|");
                String slotLocation = inputs[0];
                String productName = inputs[1];
                double price = 0.0;
                try {
                    price = Double.parseDouble(inputs[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Price is not valid number");
                }
                String type = inputs[3];

                VMItem vmItem = new VMItem(slotLocation, productName, price, type, 5);
                items.add(vmItem);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
