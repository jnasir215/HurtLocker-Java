package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ShapeStringTest {

    private static String sampleinput = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
    private static String sampleinput2 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";

    @Test
    public void TestReadData() {
        // Given
        ShapeString strArray = new ShapeString();

        // When
        int expected = 3;
        int actual = strArray.readData(sampleinput).size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestRemoveNameHeader() {
        // Given
        ShapeString strArray = new ShapeString();
        ArrayList<String> sampleinput3 = new ArrayList<>();
        sampleinput3.add("name bread price 1.23 type food expiration 1/25/2016");
        sampleinput3.add("name price 3.23 type food expiration 1/04/2016");
        sampleinput3.add("name milk price 3.23 type food expiration 1/25/2016");

        // When
        ArrayList<String> expected = new ArrayList<>();
        expected.add("bread price 1.23 type food expiration 1/25/2016");
        expected.add("price 3.23 type food expiration 1/04/2016");
        expected.add("milk price 3.23 type food expiration 1/25/2016");
        ArrayList<String> actual = strArray.removeNameHeader(sampleinput3);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestRemoveBadData() {
        // Given
        ShapeString strArray = new ShapeString();
        ArrayList<String> sampleinput4 = new ArrayList<>();
        sampleinput4.add("bread price 1.23 type food expiration 1/25/2016");
        sampleinput4.add("price 3.23 type food expiration 1/04/2016");
        sampleinput4.add("milk price 3.23 type food expiration 1/25/2016");

        // When
        int expected = 2;
        int actual = strArray.removeBadData(sampleinput4).size();

        // Then
        Assert.assertEquals(expected, actual);
    }
}
