package com.lischke.miriam.dawandaapp.model.ConversationModel;

/**
 * Created by Miriam on 13.07.2016.
 */

public class ConvContext {

    private User user;
    private User me;
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
        return "DbConvContext{" +
                "user=" + user +
                ", me=" + me +
                ", order=" + order +
                '}';
    }
}
