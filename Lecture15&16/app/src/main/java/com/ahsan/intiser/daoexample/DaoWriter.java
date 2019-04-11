package com.ahsan.intiser.daoexample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

/**
 * Created by Intiser on 11/30/2018.
 */

@Dao
public interface DaoWriter {
    @Insert
    void insertWriter(Writer writer);

    @Query("SELECT COUNT(*) FROM " + Writer.TABLE_NAME)
    int count();

    @Query("SELECT * FROM " + Writer.TABLE_NAME)
    Writer[] getAllWriter();

}
