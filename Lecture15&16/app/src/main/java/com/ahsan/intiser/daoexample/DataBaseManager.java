package com.ahsan.intiser.daoexample;

import android.arch.persistence.room.Room;


/**
 * Created by Intiser on 7/27/2018.
 */

public class DataBaseManager {
    private static DataBaseManager dataBaseManager = new DataBaseManager();

    private final AppDataBaseManager appDataBaseManager = Room.databaseBuilder(SampleApplication.getContext(), AppDataBaseManager.class, "WriterDB").build();

    public static DataBaseManager getSharedInstance() {
        return dataBaseManager;
    }

    public AppDataBaseManager getAppDataBaseManager() {
        return appDataBaseManager;
    }
}
