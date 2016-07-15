package com.lischke.miriam.dawandaapp.model.ConversationModel;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Miriam on 13.07.2016.
 */
@DatabaseTable(tableName = User.table_name_User,daoClass = BaseDaoImpl.class)
public class User {
    public static final String table_name_User = "Users";
    private static final String u_id = "u_id";
    private static final String user_id = "user_id";
    private static final String user_username = "username";
    private static final String user_avatar = "avatar";

    @DatabaseField(columnName = u_id, generatedId = true)
    private int uId;

    @DatabaseField(columnName = user_id)
    private int id;

    @DatabaseField(columnName = user_username)
    private String username;

    @DatabaseField(columnName = user_avatar)
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
