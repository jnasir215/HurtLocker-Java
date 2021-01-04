package com.codedifferently.hurt;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ItemParser {
    
    static Map<String, Map<String, Integer>> products = new LinkedHashMap<>();
    int count = 1;
    int totalCount = 1;

    public Map<String, Map<String, Integer>> extractStringArrayToHashMap(ArrayList<String> input) {
        for (String item : input) {
            String[] items = item.split(" ");
            String foodItem = items[0].replaceAll("0", "o");
            String price = items[2];
            if (products.containsKey(foodItem)) {
            } else {
                products.put(foodItem, new LinkedHashMap<String, Integer>());
            }
            if (products.get(foodItem).containsKey(price)) {
                products.get(foodItem).put(price, products.get(foodItem).get(price) + 1);
            } else {
                products.get(foodItem).put(price, 1);
            }
        }
        return products;
    }

    public void printHashMap(Map<String, Map<String, Integer>> map) {
        //int count = 1;
        for(Map.Entry<String, Map<String, Integer>> entry: map.entrySet()) {
            System.out.println("Entry #" + count + "\n" +
                                "Product Name: " + entry.getKey() + "\n");
            for(Map.Entry<String, Integer> entryDetails : entry.getValue().entrySet()) {
                System.out.println("\t\t Price " + entryDetails.getKey() + " shows up " + entryDetails.getValue() + " times.");
            totalCount = totalCount + entryDetails.getValue();
            }
            count++;
            System.out.println();
        }
        totalCount = totalCount - 1;
    }

    public StringBuilder formatOutput(int initialSize) {
        String divider1 = "===============";
        String divider2 = "---------------";
        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, Map<String, Integer>> entry : products.entrySet()) {
            int countSeen = 0;
            if (entry.getKey().length() > 5) {
                output.append("name: ").append(entry.getKey().substring(0, 1).toUpperCase()).append(entry.getKey().substring(1));
            } else {
                output.append("name: \t").append(entry.getKey().substring(0, 1).toUpperCase()).append(entry.getKey().substring(1));
            }
            for (Map.Entry<String, Integer> entryDetails : entry.getValue().entrySet()) {
                countSeen = countSeen + entryDetails.getValue();
            }
            if (countSeen > 1) {
                output.append("\t\t\t\tseen: ").append(countSeen).append(" times");
            } else {
                output.append("\t\t\t\tseen: ").append(countSeen).append(" times");
            }
            output.append("\n").append(divider1).append("\t\t\t\t").append(divider1);
            for (Map.Entry<String, Integer> entryDetails : entry.getValue().entrySet()) {
                output.append("\nPrice:\t").append(entryDetails.getKey()).append("\t\t\t\tseen: ").append(entryDetails.getValue()).append(" times");
                output.append("\n").append(divider2).append("\t\t\t\t").append(divider2);
            }
            output.append("\n\n");
        }
        output.append("Errors:\t\t\t\t\t\t").append("seen: ").append(initialSize-totalCount).append(" times");
        return output;
}

public void outputFileConverter(StringBuilder output) {
        PrintWriter txtFile;
        Integer fileCounter = 1;

        try{
            txtFile = new PrintWriter("test"+fileCounter+".txt");
            txtFile.println(output);
            fileCounter++;
            txtFile.close();
        } catch (FileNotFoundException ex) {
            System.err.println("File doesn't exist");
            ex.printStackTrace();
        }
}

    //public String findValueByPriceKey(String key, String data) {
    //    String[] dataArray = data.split(" ");
    //    String value = null;
    //    for(String item: dataArray) {
    //        String[] itemArray = item.split(" ");
    //        if(itemArray.length < 2)
    //            value = itemArray[1];
    //    }
        //if(value == null)

    //    return value;
    //}
}
