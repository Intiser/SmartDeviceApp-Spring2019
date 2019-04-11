package com.ahsan.intiser.daoexample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.jar.Attributes;

/**
 * Created by Intiser on 11/30/2018.
 */
@Entity(tableName = Writer.TABLE_NAME)
public class Writer {
    public static final String TABLE_NAME = "patients";

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "unique_id")
    private String uniqueId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "birthyear")
    private String birthYear;

    @ColumnInfo(name = "book")
    private String books;

    public static String getTableName() {
        return TABLE_NAME;
    }

    @NonNull
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(@NonNull String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }
}
