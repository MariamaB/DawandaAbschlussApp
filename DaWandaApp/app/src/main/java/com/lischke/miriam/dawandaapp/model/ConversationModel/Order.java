package com.lischke.miriam.dawandaapp.model.ConversationModel;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lischke.miriam.dawandaapp.model.Price;
import com.lischke.miriam.dawandaapp.model.Shop;

/**
 * Created by Miriam on 13.07.2016.
 */
@DatabaseTable(tableName = Order.table_name_order,daoClass = BaseDaoImpl.class)
public class Order {

    public static final String table_name_order = "order";
    private static final String o_id = "o_id";
    private static final String order_id = "order_id";
    private static final String order_created_at = "created_at";
    private static final String order_status = "status";
    private static final String order_shop = "shop";
    private static final String order_is_purchase = "is_purchase";
    private static final String order_total_price = "total_price";


    @DatabaseField(columnName = o_id, generatedId = true)
    private int oId;

    @DatabaseField(columnName = order_id)
    private int id;

    @DatabaseField(columnName = order_created_at)
    @SerializedName("created_at")
    private String createdAt;

    @DatabaseField(columnName = order_status)
    private String status;

    @DatabaseField(columnName = order_shop)
    private Shop shop;

    @DatabaseField(columnName = order_is_purchase)
    @SerializedName("is_purchase")
    private boolean isPurchase;

    @DatabaseField(columnName = order_total_price)
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
        return "Order{" +
                "id=" + id +
                ", createdAt='" + createdAt + '\'' +
                ", status='" + status + '\'' +
                ", shop=" + shop +
                ", isPurchase=" + isPurchase +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
