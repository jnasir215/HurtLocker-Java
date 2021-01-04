package com.codedifferently.hurt;

import java.util.ArrayList;
import java.util.Arrays;

public class ShapeString {

    public ArrayList<String> readData(String input) {
        String firstString = input.replaceAll("[^0-9A-Za-z-#./]+", " ");
        firstString = firstString.toLowerCase();
        String[] items = firstString.split("##");
        ArrayList<String> itemList = new ArrayList<>(Arrays.asList(items));

        return itemList;
    }

    public ArrayList<String> removeNameHeader(ArrayList<String> input){
        //for(int i = 0; i < input.size(); i++) {
        //    System.out.println("Element " + i + " in list before edits is " + input.get(i));
        //}
        for(int i = 0; i < input.size(); i++) {
            input.set(i, input.get(i).substring(5));
            System.out.println("Element " + i + " in edited list is " + input.get(i));
        }
        return input;
    }

    public ArrayList<String> removeBadData(ArrayList<String> input) {
        int count = 0;

        ArrayList<String> goodDataList = new ArrayList<>();
        for(int i = 0; i < input.size(); i++) {
            String[] items = input.get(i).split(" ");
            if(!items[0].equals("price") && !items[2].equals("type")) {
                goodDataList.add(input.get(i));
                System.out.println("Element " + count + " in list of complete data is " + goodDataList.get(count));
                count++;
            }
        }
        System.out.println("Number of elements in the list of complete data is: " + count);
        System.out.println();
        return goodDataList;
    }
}
