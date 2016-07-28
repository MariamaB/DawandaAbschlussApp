package com.lischke.miriam.dawandaapp.model.ConversationModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Miriam on 13.07.2016.
 */

public class MessageDetails {

    @SerializedName("created_at")
    private String createdAt;

    private String text;
    private boolean unread;
    private User sender;
    private User receiver;
    private Product product;



    public MessageDetails() {
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
        return "DbMessageDetails{" +
                " createdAt='" + createdAt + '\'' +
                ", text='" + text + '\'' +
                ", unread=" + unread +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", product=" + product +
                '}';
    }
}
