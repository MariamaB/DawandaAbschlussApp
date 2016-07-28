package com.lischke.miriam.dawandaapp.model.DatabaseModel;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Conversation;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Order;
import com.lischke.miriam.dawandaapp.model.ConversationModel.User;

/**
 * Created by Miriam on 13.07.2016.
 */
@DatabaseTable(tableName = DbConvContext.table_name_convContext, daoClass = BaseDaoImpl.class)
public class DbConvContext {

    public static final String table_name_convContext = "ConversationContext";
    private static final String co_id = "co_id";
    private static final String convCon_user = "user";
    private static final String convCon_me = "me";
    private static final String convCon_order = "order";

    public DbConvContext() {
    }

    public DbConvContext(Conversation c) {

        user = c.getContext().getUser().getId();
        me = c.getContext().getMe().getId();
        if(c.getContext().getOrder() != null) {
            order = c.getContext().getOrder().getOrderId();
        }
    }

    @DatabaseField(columnName = co_id, generatedId = true)
    private int coId;

    @DatabaseField(columnName = convCon_user)
    private int user = new User().getId();
    
    @DatabaseField(columnName = convCon_me)
    private int me = new User().getId();

    @DatabaseField(columnName = convCon_order)
    private int order = new Order().getOrderId();


    public int getCoId() {
        return coId;
    }

    public int getUser() {
        return user;
    }

    public int getMe() {
        return me;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "DbConvContext{" +
                "coId=" + coId +
                ", user=" + user +
                ", me=" + me +
                ", order=" + order +
                '}';
    }
}
