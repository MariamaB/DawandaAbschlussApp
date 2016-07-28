package com.lischke.miriam.dawandaapp.model.DatabaseModel;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lischke.miriam.dawandaapp.model.ConversationModel.Conversation;

/**
 * Created by Miriam on 27.07.2016.
 */
@DatabaseTable(tableName = DbDatabaseNames.table_name_database_names, daoClass = BaseDaoImpl.class)
public class DbDatabaseNames {

    public static final String table_name_database_names = "databaseNames";
    public static final String d_id = "d_id";
    public static final String database_name = "storedDatabaseNames";

    public DbDatabaseNames(Conversation c) {

        this.name = ""+c.getContext().getMe().getId();

    }


    public DbDatabaseNames() {
    }



    @DatabaseField(columnName = d_id, generatedId = true)
    private int dId;

    @DatabaseField(columnName = database_name)
    private String name;


    public int getdId() {
        return dId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DbDatabaseNames{" +
                "dId=" + dId +
                ", name=" + name +
                '}';
    }
}
