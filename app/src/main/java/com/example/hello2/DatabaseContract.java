package com.example.hello2;

import android.provider.BaseColumns;

public class DatabaseContract {

    private DatabaseContract() {}

    public static class DataEntry implements BaseColumns {
        public static final String TABLE_NAME = "data";
        public static final String COLUMN_NAME_DATA = "data";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_DATA + " TEXT)";
    }
}
