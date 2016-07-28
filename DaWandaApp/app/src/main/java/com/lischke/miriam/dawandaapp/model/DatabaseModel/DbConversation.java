package com.lischke.miriam.dawandaapp.model.DatabaseModel;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Conversation;

/**
 * Created by Miriam on 13.07.2016.
 */
@DatabaseTable(tableName = DbConversation.table_name_conversation, daoClass = BaseDaoImpl.class)
public class DbConversation {

    public static final String table_name_conversation = "conversations";
    public static final String c_id = "c_id";
    private static final String conversation_id = "conversation_id";
    private static final String conv_type = "type";
    private static final String conv_context = "context";


    public DbConversation() {
    }


    public DbConversation(Conversation c) {
        conversationId = c.getConversationId();
        if(c.getContext().getOrder() != null) {context = c.getContext().getOrder().getOrderId();}
        type = c.getType();


    }

    @DatabaseField(columnName = c_id, generatedId = true)
    private int cId;

    @DatabaseField(columnName = conversation_id)
    private String conversationId = new Conversation().getConversationId();

    @DatabaseField(columnName = conv_type)
    private String type;

    @DatabaseField(columnName = conv_context)
    private int context;

    public String getConversationId() {
        return conversationId;
    }

    public String getType() {
        return type;
    }


    public int getcId() {
        return cId;
    }

    public int getContext() {
        return context;
    }

    @Override
    public String toString() {
        return "DbConversation{" +
                "cId=" + cId +
                ", conversationId='" + conversationId + '\'' +
                ", type='" + type + '\'' +
                ", context=" + context +
                '}';
    }
}
