package com.lischke.miriam.dawandaapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Miriam on 08.07.2016.
 */
public class Session {

    @SerializedName("id")
    int userId;

    @SerializedName("platform")
    String platform;

    @SerializedName("tapglueId")
    String tapglueId;

    @SerializedName("sid")
    String sid;

    public int getUserId() {
        return userId;
    }

    public String getPlatform() {

        return platform;
    }

    public String getTapglueId() {
        return tapglueId;
    }

    public String getSid() {
        return sid;
    }



    @Override
    public String toString() {
        return "Session{" +
                "userId=" + userId +
                ", platform='" + platform + '\'' +
                ", tapglueId='" + tapglueId + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }


}

