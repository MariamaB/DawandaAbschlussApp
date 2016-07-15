package com.lischke.miriam.dawandaapp.model.ConversationModel;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Miriam on 13.07.2016.
 */

@DatabaseTable(tableName = Conversation.table_name_conversation, daoClass = BaseDaoImpl.class)
public class Conversation {

    public static final String table_name_conversation = "conversations";

    public static final String c_id = "c_id";
    private static final String conversation_id = "conversation_id";
    private static final String conv_type = "type";
    private static final String conv_context = "context";
//    private static final String conv_messages = "messages";


    @DatabaseField(columnName = c_id, generatedId = true)
    private int cId;


    @DatabaseField(columnName = conversation_id)
    @SerializedName("id")
    private String conversationId;

    @DatabaseField(columnName = conv_type)
    private String type;

    @DatabaseField(columnName = conv_context)
    private ConvContext context;


//    @DatabaseField(columnName = conv_messages)
//    private Messages messages;




    public String getConversationId() {
        return conversationId;
    }

    public String getType() {
        return type;
    }

    public ConvContext getContext() {
        return context;
    }

//    public Messages getMessages() {
//        return messages;
//    }



    @Override
    public String toString() {
        return "Conversation{" +
                "idA=" + cId +
                ", conversationId='" + conversationId + '\'' +
                ", type='" + type + '\'' +
                ", context=" + context +
                '}';
    }

}
