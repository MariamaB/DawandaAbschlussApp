package com.lischke.miriam.dawandaapp.model.DatabaseModel;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Conversation;


/**
 * Created by Miriam on 27.06.2016.
 */
@DatabaseTable(tableName = DbShop.table_name_shops, daoClass = BaseDaoImpl.class)
public class DbShop {

    public static final String table_name_shops = "shops";
    public static final String sh_id = "sh_id";
    public static final String shop_id = "shop_id";
    public static final String shop_subdomain = "shop_subdomain";
    public static final String shop_title = "shop_title";

    public DbShop() {
    }

    public DbShop(Conversation c) {


        shopId = c.getContext().getOrder().getShop().getShopId();
        subdomain = c.getContext().getOrder().getShop().getSubdomain();
        title = c.getContext().getOrder().getShop().getTitle();

    }

    @DatabaseField(columnName = sh_id, generatedId = true)
    private int shId;

    @DatabaseField(columnName = shop_id)
    private String shopId;

    @DatabaseField(columnName = shop_subdomain)
    private String subdomain;

    @DatabaseField(columnName = shop_title)
    private String title;


    public int getShId() {
        return shId;
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
        return "DbShop{" +
                "shId=" + shId +
                ", shopId='" + shopId + '\'' +
                ", subdomain='" + subdomain + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
