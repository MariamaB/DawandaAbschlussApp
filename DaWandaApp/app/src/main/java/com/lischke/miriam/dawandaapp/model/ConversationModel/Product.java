package com.lischke.miriam.dawandaapp.model.ConversationModel;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lischke.miriam.dawandaapp.model.Price;

/**
 * Created by Miriam on 13.07.2016.
 */
@DatabaseTable(tableName = Product.table_name_product,daoClass = BaseDaoImpl.class)

public class Product {

    public static final String table_name_product = "product";
    private static final String s_id = "s_id";
    private static final String product_id = "product_id";
    private static final String product_price = "price";
    private static final String product_title = "title";
    private static final String product_image = "image";


    @DatabaseField(columnName = s_id, generatedId = true)
    private int sId;

    @DatabaseField(columnName = product_id)
    private int id;

    @DatabaseField(columnName = product_price)
    private Price price;

    @DatabaseField(columnName = product_title)
    private String title;

    @DatabaseField(columnName = product_image)
    private String image;

    public Product() {
    }

    public int getProductId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
