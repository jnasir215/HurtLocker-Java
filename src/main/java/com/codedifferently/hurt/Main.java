package com.codedifferently.hurt;

import org.apache.commons.io.IOUtils;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
        int initialSize;

        try {
            String output = (new Main()).readRawDataToString();
            System.out.println(output);
            ShapeString initialData = new ShapeString();
            ArrayList<String> initialList = initialData.readData(output);
            initialSize = initialList.size();
            System.out.println("Number of elements in the initial list is: " + initialSize);
            ArrayList<String> secondList = initialData.removeNameHeader(initialList);
            ArrayList<String> thirdList = initialData.removeBadData(secondList);
            ItemParser newItem = new ItemParser();
            Map<String, Map<String, Integer>> hashMap = newItem.extractStringArrayToHashMap(thirdList);
            newItem.printHashMap(hashMap);
            newItem.outputFileConverter(newItem.formatOutput(initialSize));
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
