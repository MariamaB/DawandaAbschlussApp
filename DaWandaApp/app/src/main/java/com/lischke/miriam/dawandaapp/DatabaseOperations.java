package com.lischke.miriam.dawandaapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbConvContext;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbConversation;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbDatabaseNames;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbMessageDetails;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbOrder;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbProduct;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbShop;
import com.lischke.miriam.dawandaapp.model.DatabaseModel.DbUser;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Miriam on 15.07.2016.
 */

public class DatabaseOperations extends OrmLiteSqliteOpenHelper {

    public ArrayList storeDatabaseName;
    public static  String database_name;
    public static  int database_version = 1;


    private Dao<DbProduct, Integer> productDao = null;
    private Dao<DbConversation, Integer> conversationsDao = null;
    private Dao<DbShop, Integer> shopDao = null;
    private Dao<DbUser, Integer> userDao = null;
    private Dao<DbOrder, Integer> orderDao = null;
    private Dao<DbMessageDetails, Integer> messagesDao = null;
    private Dao<DbConvContext, Integer> convConDao = null;
    private Dao<DbDatabaseNames, Integer> databaseNames = null;

    public DatabaseOperations(Context context){

        super(context, ""+ConversationsActivity.responsebody.get(0).getContext().getMe().getId(), null, database_version);
        Log.d("Database Operations","Created Database: "+database_name);

    }

    public DatabaseOperations(Context context, String name) {
        super(context, name, null, database_version);
        Log.d("Database Operations", "Created Database: " + database_name);
    }

//        String.valueOf(context.getText(R.id.db_name))




    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, DbProduct.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, DbConversation.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, DbShop.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, DbUser.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, DbOrder.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, DbMessageDetails.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, DbConvContext.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, DbDatabaseNames.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Log.d("Database Operations","Created Table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }



    public Dao<DbProduct, Integer> getProductDao() throws SQLException {
        if (productDao == null) {
            productDao = getDao(DbProduct.class);
        }

        return productDao;
    }

    public void productClose() {
       productDao = null;

        super.close();
    }




    public Dao<DbConversation, Integer> getConversationDao() throws SQLException {
        if (conversationsDao == null) {
            conversationsDao = getDao(DbConversation.class);
        }

        return conversationsDao;
    }


    public void conversationClose() {
        conversationsDao = null;

        super.close();
    }




    public Dao<DbShop, Integer> getShopDao() throws SQLException {
        if (shopDao == null) {
            shopDao = getDao(DbShop.class);
        }

        return shopDao;
    }


    public void shopClose() {
        shopDao = null;

        super.close();
    }





    public Dao<DbUser, Integer> getUserDao() throws SQLException {
        if (userDao == null) {
            userDao = getDao(DbUser.class);
        }

        return userDao;
    }


    public void userClose() {
        userDao = null;

        super.close();
    }




    public Dao<DbMessageDetails, Integer> getMessagesDao() throws SQLException {
        if (messagesDao == null) {
            messagesDao = getDao(DbMessageDetails.class);
        }

        return messagesDao;
    }


    public void messagesClose() {
        messagesDao = null;

        super.close();
    }




    public Dao<DbOrder, Integer> getOrderDao() throws SQLException {
        if (orderDao == null) {
            orderDao = getDao(DbOrder.class);
        }

        return orderDao;
    }


    public void orderClose() {
        orderDao = null;

        super.close();
    }




    public Dao<DbConvContext, Integer> getConvConDao() throws SQLException {
        if (convConDao == null) {
            convConDao = getDao(DbConvContext.class);
        }

        return convConDao;
    }


    public void convConClose() {
        convConDao = null;

        super.close();
    }

    public Dao<DbDatabaseNames, Integer> getDatabasenameList() throws SQLException {
        if (databaseNames == null) {
            databaseNames = getDao(DbDatabaseNames.class);
        }

        return databaseNames;
    }


    public void databasenameListClose() {


        super.close();
    }


//    GenericRawResults<String[]> results =
//           dao.queryRaw("SELECT name FROM sqlite_master WHERE type = 'table'");
//    for (String[] result : results) {
//        System.out.println("One table is: " + result[0]);
//    }

}
