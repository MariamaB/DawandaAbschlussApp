package com.lischke.miriam.dawandaapp.model.DatabaseModel;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Conversation;

/**
 * Created by Miriam on 13.07.2016.
 */
@DatabaseTable(tableName = DbMessageDetails.table_name_message, daoClass = BaseDaoImpl.class)
public class DbMessageDetails {

    public static final String table_name_message = "messages";
    public static final String m_id = "m_id";
    public static final String mess_creaated_at = "created_at";
    public static final String mess_text = "text";
    public static final String mess_unread = "unread";
    public static final String mess_sender = "sender";
    public static final String mess_reciver = "reciver";
    public static final String mess_product = "product";


    public DbMessageDetails() {
    }

    public DbMessageDetails(Conversation c) {

        for (int i = 0; i < c.getMessages().size(); i++){
            createdAt = c.getMessages().get(i).getCreatedAt();
            text = c.getMessages().get(i).getText();
            unread = c.getMessages().get(i).isUnread();
            sender = c.getMessages().get(i).getSender().getId();
            receiver = c.getMessages().get(i).getReceiver().getId();
            if (c.getMessages().get(i).getProduct() != null) {
                product = c.getMessages().get(i).getProduct().getProductId();
            }
        }
    }

    @DatabaseField(columnName = m_id, generatedId = true)
    private int mId;

    @DatabaseField(columnName = mess_creaated_at)
    private String createdAt;

    @DatabaseField(columnName = mess_text)
    private String text;

    @DatabaseField(columnName = mess_unread)
    private boolean unread;

    @DatabaseField(columnName = mess_sender)
    private int sender;

    @DatabaseField(columnName = mess_reciver)
    private int receiver;

    @DatabaseField(columnName = mess_product)
    private int product;



    public int getreciver() {
        return receiver;
    }

    public int getSender() {
        return sender;
    }

    public int getmId() {
        return mId;
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

    public int getReceiver() {
        return receiver;
    }

    public int getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "DbMessageDetails{" +
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
