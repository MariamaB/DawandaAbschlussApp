package com.lischke.miriam.dawandaapp.model.DatabaseModel;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Conversation;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Order;
import com.lischke.miriam.dawandaapp.model.Price;
import com.lischke.miriam.dawandaapp.model.Shop;

/**
 * Created by Miriam on 13.07.2016.
 */
@DatabaseTable(tableName = DbOrder.table_name_order,daoClass = BaseDaoImpl.class)
public class DbOrder {

    public static final String table_name_order = "order";
    private static final String o_id = "o_id";
    private static final String order_id = "order_id";
    private static final String order_created_at = "created_at";
    private static final String order_status = "status";
    private static final String order_shop = "shop";
    private static final String order_is_purchase = "is_purchase";
    private static final String order_total_price = "total_price";

    public DbOrder() {
    }

    public DbOrder(Conversation c) {

        id = c.getContext().getOrder().getOrderId();
        createdAt = c.getContext().getOrder().getCreatedAt();
        status = c.getContext().getOrder().getStatus();
        shop = c.getContext().getOrder().getShop().getShopId();
        isPurchase = c.getContext().getOrder().isPurchase();
        totalPrice = c.getContext().getOrder().getTotalPrice().getPrice();
    }

    @DatabaseField(columnName = o_id, generatedId = true)
    private int oId;

    @DatabaseField(columnName = order_id)
    private int id;

    @DatabaseField(columnName = order_created_at)
    private String createdAt = new Order().getCreatedAt();

    @DatabaseField(columnName = order_status)
    private String status;

    @DatabaseField(columnName = order_shop)
    private String shop = new Shop().getShopId();

    @DatabaseField(columnName = order_is_purchase)
    private boolean isPurchase = new Order().isPurchase();

    @DatabaseField(columnName = order_total_price)
    private String totalPrice = new Price().getPrice();

    public int getoId() {
        return oId;
    }

    public int getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getStatus() {
        return status;
    }

    public String getShop() {
        return shop;
    }

    public boolean isPurchase() {
        return isPurchase;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "DbOrder{" +
                "oId=" + oId +
                ", id=" + id +
                ", createdAt='" + createdAt + '\'' +
                ", status='" + status + '\'' +
                ", shop='" + shop + '\'' +
                ", isPurchase=" + isPurchase +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }
}
