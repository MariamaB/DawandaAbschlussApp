package com.lischke.miriam.dawandaapp.model.ConversationModel;

/**
 * Created by Miriam on 13.07.2016.
 */
public class User {

    private int id;
    private String username;
    private String avatar;


    public User() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
