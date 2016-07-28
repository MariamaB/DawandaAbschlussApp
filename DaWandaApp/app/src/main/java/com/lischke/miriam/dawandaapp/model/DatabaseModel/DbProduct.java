package com.lischke.miriam.dawandaapp.model.DatabaseModel;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Conversation;



/**
 * Created by Miriam on 13.07.2016.
 */
@DatabaseTable(tableName = DbProduct.table_name_product,daoClass = BaseDaoImpl.class)

public class DbProduct {

    public static final String table_name_product = "product";
    private static final String s_id = "s_id";
    private static final String product_id = "product_id";
    private static final String product_price = "price";
    private static final String product_title = "title";
    private static final String product_image = "image";

    public DbProduct() {
    }

    public DbProduct(Conversation c) {

        for (int i = 0; i < c.getMessages().size(); i++) {
            id = c.getMessages().get(i).getProduct().getProductId();
            price = c.getMessages().get(i).getProduct().getPrice().getPrice();
            title = c.getMessages().get(i).getProduct().getTitle();
            image = c.getMessages().get(i).getProduct().getImage();
        }
    }

    @DatabaseField(columnName = s_id, generatedId = true)
    private int sId;

    @DatabaseField(columnName = product_id)
    private int id;

    @DatabaseField(columnName = product_price)
    private String price;

    @DatabaseField(columnName = product_title)
    private String title;

    @DatabaseField(columnName = product_image)
    private String image;


    public int getsId() {
        return sId;
    }

    public int getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "DbProduct{" +
                "sId=" + sId +
                ", id=" + id +
                ", price='" + price + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
