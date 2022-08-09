package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class VMInventoryTest {
    VMInventory vmInventory;

    @Before
    public void constructVMInventory() {
        vmInventory = new VMInventory("vendingmachine.csv");
    }

    @Test
    public void testLoadInventoryShouldLoadAtLeastOneItem() {
        // A1|Potato Crisps|3.05|Chip
        VMItem expected = new VMItem("A1", "Potato Crisps", 3.05, "Chip", 5);
        VMItem actual = vmInventory.getVMItemBySlotLocation("A1");

        Assert.assertEquals(expected.getSlotLocation(), actual.getSlotLocation());
        Assert.assertEquals(expected.getProductName(), actual.getProductName());
        Assert.assertEquals(expected.getPrice(), actual.getPrice(),0.0);
        Assert.assertEquals(expected.getType(), actual.getType());
        Assert.assertEquals(expected.getQuantity(), actual.getQuantity());
    }

    @Test
    public void testLoadInventoryShouldLoadAllItems() {
        int expected = 16;
        int actual = vmInventory.getItems().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetItemsByTypesReturnsMapOfTypes() {
        Map<String, List<VMItem>> actual = vmInventory.getVMItemsByTypes();

        for(VMItem item : actual.get(VMInventory.TYPE_CHIP)) {
            Assert.assertEquals(VMInventory.TYPE_CHIP, item.getType());
        }

        for(VMItem item : actual.get(VMInventory.TYPE_CANDY)) {
            Assert.assertEquals(VMInventory.TYPE_CANDY, item.getType());
        }

        for(VMItem item : actual.get(VMInventory.TYPE_DRINK)) {
            Assert.assertEquals(VMInventory.TYPE_DRINK, item.getType());
        }

        for(VMItem item : actual.get(VMInventory.TYPE_GUM)) {
            Assert.assertEquals(VMInventory.TYPE_GUM, item.getType());
        }
    }
}
