package com.zero.project.helloworld.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.zero.project.helloworld.database.DatabaseHelper;

import java.util.HashMap;

/**
 * Created by Gopi on 12-09-2016.
 */
public class StudentProvider extends ContentProvider {

    public static final String PROVIDER_NAME = "com.zero.provider.college";
    public static final String URL = "content://" + PROVIDER_NAME + "/students";
    public static final Uri CONTENT_URI = Uri.parse(URL);
    public static final String TAG = "Content Provider::";
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String GRADE = "grade";
    static final int STUDENTS = 1;
    static final int STUDENTS_ID = 2;
    static final UriMatcher uriMatcher;
    static final String STUDENTS_TABLE_NAME = "students";
    private static HashMap<String, String> STUDENTS_PROJECTION_MAP;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "students", STUDENTS);
        uriMatcher.addURI(PROVIDER_NAME, "students/#", STUDENTS_ID);
    }

    private SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        Context context = getContext();
        boolean status = false;
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        /**
         * Create a writable database
         */
        db = databaseHelper.getWritableDatabase();
        if (db != null) {
            status = true;
        }
        return status;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        Log.d(TAG, "getType: ");
        switch (uriMatcher.match(uri)) {
            /**
             * get all students record
             */
            case STUDENTS:
                return "vnd.android.cursor.dir/vnd.example.students";
            /**
             * get invidual student record
             */
            case STUDENTS_ID:
                return "vnd.android.cursor.item/vnd.example.students";

            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.d(TAG, "insert: ");
        /**
         * Add a new record
         */
        long rowID = db.insert(STUDENTS_TABLE_NAME, "", values);
        if (rowID > 0) {
            Uri uri1 = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(uri1, null);
            return uri1;
        }
        throw new SQLException("Failed to add record into " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
