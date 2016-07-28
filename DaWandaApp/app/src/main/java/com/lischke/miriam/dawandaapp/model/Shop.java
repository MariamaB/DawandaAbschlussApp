package com.lischke.miriam.dawandaapp.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by Miriam on 27.06.2016.
 */
public class Shop {

    @SerializedName("id")
    private String shopId;
    private String subdomain;
    private String title;



    public Shop() {
    }



    public String getShopId() {
        return shopId;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public String getTitle() {
        return title;
    }



    @Override
    public String toString() {
        return "Shop{" +
                 "shopId='" + shopId + '\'' +
                ", subdomain='" + subdomain + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
