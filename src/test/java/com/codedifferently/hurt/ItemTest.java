package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    @Test
    public void TestItem1() {
        String food = "Milk";
        Double cost = 3.23;
        String category = "Food";
        String expiry = "1/25/2016";

        Item foodList = new Item(food, cost, category, expiry);

        String expectedValue = "Milk";
        String actualValue = foodList.getProduct();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void TestItem2() {
        String food = "Milk";
        Double cost = 3.23;
        String category = "Food";
        String expiry = "1/25/2016";

        Item foodList = new Item(food, cost, category, expiry);

        Double expectedValue = 3.23;
        Double actualValue = foodList.getPrice();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void TestItem3() {
        String food = "Milk";
        Double cost = 3.23;
        String category = "Food";
        String expiry = "1/25/2016";

        Item foodList = new Item(food, cost, category, expiry);

        String expectedValue = "Food";
        String actualValue = foodList.getType();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void TestItem4() {
        String food = "Milk";
        Double cost = 3.23;
        String category = "Food";
        String expiry = "1/25/2016";

        Item foodList = new Item(food, cost, category, expiry);

        String expectedValue = "1/25/2016";
        String actualValue = foodList.getExpiration();

        Assert.assertEquals(expectedValue, actualValue);
    }
}