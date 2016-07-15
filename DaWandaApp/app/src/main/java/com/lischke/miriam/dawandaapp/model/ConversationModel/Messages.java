package com.lischke.miriam.dawandaapp.model.ConversationModel;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Miriam on 13.07.2016.
 */
@DatabaseTable(tableName = Messages.table_name_message, daoClass = BaseDaoImpl.class)
public class Messages {

    public static final String table_name_message = "messages";
    private static final String m_id = "m_id";
    private static final String mess_creaated_at = "created_at";
    private static final String mess_text = "text";
    private static final String mess_unread = "unread";
    private static final String mess_sender = "sender";
    private static final String mess_reciver = "reciver";
    private static final String mess_product = "product";



    @DatabaseField(columnName = m_id, generatedId = true)
    private int mId;

    @DatabaseField(columnName = mess_creaated_at)
    @SerializedName("created_at")
    private String createdAt;

    @DatabaseField(columnName = mess_text)
    private String text;

    @DatabaseField(columnName = mess_unread)
    private boolean unread;

    @DatabaseField(columnName = mess_sender)
    private User sender;

    @DatabaseField(columnName = mess_reciver)
    private User receiver;

    @DatabaseField(columnName = mess_product)
    private Product product;


    public Messages() {
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getText() {
        return text;
    }

    public boolean isUnread() {
        return unread;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "mId=" + mId +
                ", createdAt='" + createdAt + '\'' +
                ", text='" + text + '\'' +
                ", unread=" + unread +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", product=" + product +
                '}';
    }
}
