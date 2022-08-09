package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class FinishTransactionTest {
    @Test
    public void testFinishTransctionReturnsTheRightChange() {
        FinishTransaction ft = new FinishTransaction(2.40);
        ft.returnChange();
        int actualQuarters = ft.getQuarters();
        int actualDimes = ft.getDimes();
        int actualNickels = ft.getNickels();

        int expectedQuarters = 9;
        int expectedDimes = 1;
        int expectedNickels = 1;

        Assert.assertEquals(expectedQuarters, actualQuarters);
        Assert.assertEquals(expectedDimes, actualDimes);
        Assert.assertEquals(expectedNickels, actualNickels);
    }
}
