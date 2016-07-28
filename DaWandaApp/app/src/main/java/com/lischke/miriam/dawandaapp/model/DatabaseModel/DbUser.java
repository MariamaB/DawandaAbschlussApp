package com.lischke.miriam.dawandaapp.model.DatabaseModel;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Conversation;

/**
 * Created by Miriam on 13.07.2016.
 */
@DatabaseTable(tableName = DbUser.table_name_User,daoClass = BaseDaoImpl.class)
public class DbUser {
    public static final String table_name_User = "Users";
    public static final String u_id = "u_id";
    public static final String user_id = "user_id";
    public static final String user_username = "username";
    public static final String user_avatar = "avatar";


    public DbUser() {
    }

    public DbUser(Conversation c) {

        id = c.getContext().getUser().getId();
        username = c.getContext().getUser().getUsername();
        avatar = c.getContext().getUser().getAvatar();
    }

    @DatabaseField(columnName = u_id, generatedId = true)
    public int uId;

    @DatabaseField(columnName = user_id)
    public int id;

    @DatabaseField(columnName = user_username)
    public String username;

    @DatabaseField(columnName = user_avatar)
    public String avatar;


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getuId() {
        return uId;
    }

    @Override
    public String toString() {
        return "DbUser{" +
                "uId=" + uId +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
