package com.lischke.miriam.dawandaapp.model.ConversationModel;

import com.google.gson.annotations.SerializedName;
import com.lischke.miriam.dawandaapp.model.Price;
import com.lischke.miriam.dawandaapp.model.Shop;

/**
 * Created by Miriam on 13.07.2016.
 */
public class Order {

    private int id;
    @SerializedName("created_at")
    private String createdAt;
    private String status;
    private Shop shop;
    @SerializedName("is_purchase")
    private boolean isPurchase;
    @SerializedName("total_price")
    private Price totalPrice;


    public Order() {
    }


    public int getOrderId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getStatus() {
        return status;
    }

    public Shop getShop() {
        return shop;
    }

    public boolean isPurchase() {
        return isPurchase;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "DbOrder{" +
                "id=" + id +
                ", createdAt='" + createdAt + '\'' +
                ", status='" + status + '\'' +
                ", shop=" + shop +
                ", isPurchase=" + isPurchase +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
