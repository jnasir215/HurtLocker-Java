package com.codedifferently.hurt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Item {

    String product;
    Double price;
    String type;
    String expiration;
    Map<String, String> namePair = new HashMap<>();
    Map<String, Double> pricePair = new HashMap<>();
    Map<String, String> typePair = new HashMap<>();
    Map<String, String> expiryPair = new HashMap<>();

    public Item(String product, Double price, String type, String expiration) {
        this.product = product;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public Item(Map<String, String> rawDataMap) {
        this.product = "name";
        this.price = Double.parseDouble(rawDataMap.get("price"));
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String checkProductHeader(String nameHeader) {
        if(nameHeader.equals("(?)name")) {
            nameHeader = ("[N]ame");
        }
        return nameHeader;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String checkPriceHeader(String priceHeader) {
        if(priceHeader.equals("(?)price")) {
            priceHeader = ("[P]rice");
        }
        return priceHeader;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String checkTypeHeader(String typeHeader) {
        if(typeHeader.equals("(?)type")) {
            typeHeader = ("[T]ype");
        }
        return typeHeader;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String checkDateHeader(String dateHeader) {
        if(dateHeader.equals("(?)date")) {
            dateHeader = ("[D]ate");
        }
        return dateHeader;
    }
}
