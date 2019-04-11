package com.ahsan.intiser.daoexample;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Intiser on 11/30/2018.
 */
@Database(entities = {Writer.class}, version = 1)
public abstract class AppDataBaseManager extends RoomDatabase{
    public abstract DaoWriter daoWriter();
}
