package com.lischke.miriam.dawandaapp.model.ConversationModel;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Miriam on 13.07.2016.
 */
@DatabaseTable(tableName = ConvContext.table_name_convContext, daoClass = BaseDaoImpl.class)
public class ConvContext {

    public static final String table_name_convContext = "ConversationContext";
    private static final String co_id = "co_id";
    private static final String convCon_user = "user";
    private static final String convCon_me = "me";
    private static final String convCon_order = "order";


    @DatabaseField(columnName = co_id, generatedId = true)
    private int coId;

    @DatabaseField(columnName = convCon_user)
    private User user;
    
    @DatabaseField(columnName = convCon_me)
    private User me;

    @DatabaseField(columnName = convCon_order)
    private Order order;


    public ConvContext() {
    }

    public User getUser() {
        return user;
    }

    public User getMe() {
        return me;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "ConvContext{" +
                "user=" + user +
                ", me=" + me +
                ", order=" + order +
                '}';
    }
}
