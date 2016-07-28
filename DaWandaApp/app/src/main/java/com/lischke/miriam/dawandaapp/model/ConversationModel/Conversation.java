package com.lischke.miriam.dawandaapp.model.ConversationModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Miriam on 13.07.2016.
 */

public class Conversation {

    @SerializedName("id")
    private String conversationId;
    private String type;
    private ConvContext context;
    private List<MessageDetails> messages;

    public Conversation() {
    }

    public String getConversationId() {
        return conversationId;
    }

    public String getType() {
        return type;
    }

    public ConvContext getContext() {
        return context;
    }

    public List< MessageDetails >getMessages() {
        return messages;
    }


    @Override
    public String toString() {
        return "DbConversation{" +
                ", conversationId='" + conversationId + '\'' +
                ", type='" + type + '\'' +
                ", context=" + context +
                ", messages=" + messages +
                '}';
    }
}
