package com.lischke.miriam.dawandaapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.lischke.miriam.dawandaapp.model.ConversationModel.ConvContext;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Conversation;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Messages;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Order;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Product;
import com.lischke.miriam.dawandaapp.model.ConversationModel.User;
import com.lischke.miriam.dawandaapp.model.Shop;

import java.sql.SQLException;

/**
 * Created by Miriam on 15.07.2016.
 */
public class DatabaseOperations extends OrmLiteSqliteOpenHelper {


    public static final String database_name = "conversations_database.db";
    public static final int database_version = 1;


    private Dao<Product, Integer> productDao = null;
    private Dao<Conversation, Integer> conversationsDao = null;
    private Dao<Shop, Integer> shopDao = null;
    private Dao<User, Integer> userDao = null;
    private Dao<Order, Integer> orderDao = null;
    private Dao<Messages, Integer> messagesDao = null;
    private Dao<ConvContext, Integer> convConDao = null;


    public DatabaseOperations(Context context) {
        super(context, database_name, null, database_version);
        Log.d("Database Operations","Created Database");
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {


        try {
            TableUtils.createTable(connectionSource, Product.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, Conversation.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, Shop.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, Order.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, Messages.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, ConvContext.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Log.d("Database Operations","Created Table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public Dao<Product, Integer> getProductDao() throws SQLException {
        if (productDao == null) {
            productDao = getDao(Product.class);
        }

        return productDao;
    }

    public void productClose() {
       productDao = null;

        super.close();
    }




    public Dao<Conversation, Integer> getConversationDao() throws SQLException {
        if (conversationsDao == null) {
            conversationsDao = getDao(Conversation.class);
        }

        return conversationsDao;
    }


    public void conversationClose() {
        conversationsDao = null;

        super.close();
    }




    public Dao<Shop, Integer> getShopDao() throws SQLException {
        if (shopDao == null) {
            shopDao = getDao(Shop.class);
        }

        return shopDao;
    }


    public void shopClose() {
        shopDao = null;

        super.close();
    }





    public Dao<User, Integer> getUserDao() throws SQLException {
        if (userDao == null) {
            userDao = getDao(User.class);
        }

        return userDao;
    }


    public void userClose() {
        userDao = null;

        super.close();
    }




    public Dao<Messages, Integer> getMessagesDao() throws SQLException {
        if (messagesDao == null) {
            messagesDao = getDao(Messages.class);
        }

        return messagesDao;
    }


    public void messagesClose() {
        messagesDao = null;

        super.close();
    }




    public Dao<Order, Integer> getOrderDao() throws SQLException {
        if (orderDao == null) {
            orderDao = getDao(Order.class);
        }

        return orderDao;
    }


    public void orderClose() {
        orderDao = null;

        super.close();
    }





    public Dao<ConvContext, Integer> getConvConDao() throws SQLException {
        if (convConDao == null) {
            convConDao = getDao(ConvContext.class);
        }

        return convConDao;
    }


    public void convConClose() {
        convConDao = null;

        super.close();
    }

}
