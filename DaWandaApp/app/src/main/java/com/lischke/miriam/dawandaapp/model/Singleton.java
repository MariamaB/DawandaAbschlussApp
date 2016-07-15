package com.lischke.miriam.dawandaapp.model;

/**
 * Created by Miriam on 08.07.2016.
 */
public class Singleton {

    private Singleton(){

    }

    private static final Singleton instance = new Singleton();

    private Session session;

    public static Singleton getInstance(){
        return instance;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
