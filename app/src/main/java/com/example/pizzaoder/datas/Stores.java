package com.example.pizzaoder.datas;

import java.io.Serializable;

public class Stores implements Serializable {

    public String storeName;
    public String openTime;
    public String phoneNumber;
    public String logoUrl;

    public Stores(String storeName, String openTime, String phoneNumber, String logoUrl) {
        this.storeName = storeName;
        this.openTime = openTime;
        this.phoneNumber = phoneNumber;
        this.logoUrl = logoUrl;
    }
}
