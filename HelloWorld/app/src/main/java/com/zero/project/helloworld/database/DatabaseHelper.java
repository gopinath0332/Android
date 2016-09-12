package com.zero.project.helloworld.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gopi on 12-09-2016.
 * Helper class to create and manage the provider's underlying data
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    /**
     * Database specific constants
     */
    static final String STUDENTS_TABLE_NAME = "students";
    static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "College";
    private static final String CREATE_DB_TABLE = "CREATE TABLE " + STUDENTS_TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, grade TEXT NOT NULL)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + STUDENTS_TABLE_NAME);
        onCreate(db);
    }
}
