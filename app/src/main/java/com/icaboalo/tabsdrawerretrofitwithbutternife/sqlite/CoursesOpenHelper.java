package com.icaboalo.tabsdrawerretrofitwithbutternife.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.icaboalo.tabsdrawerretrofitwithbutternife.sqlite.Constants.DbConstants;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class CoursesOpenHelper extends SQLiteOpenHelper {

    public CoursesOpenHelper(Context context) {
        super(context, DbConstants.DATABASE_NAME, null, DbConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbConstants.CREATE_TABLE_UDACITY);
        db.execSQL(DbConstants.CREATE_TABLE_COURSEA);
        db.execSQL(DbConstants.CREATE_TABLE_USERS);
    }

    public void insertUser(String username, String password, String firstName, String lastName) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues insertUserValues = new ContentValues();
        insertUserValues.put(DbConstants.COLUMN_USERNAME, username);
        insertUserValues.put(DbConstants.COLUMN_PASSWORD, password);
        insertUserValues.put(DbConstants.COLUMN_FIRST_NAME, firstName);
        insertUserValues.put(DbConstants.COLUMN_LAST_NAME, lastName);
        db.insert(DbConstants.TABLE_USERS, null, insertUserValues);

        db.close();
    }

    public String getUser(String username) {
        SQLiteDatabase dbRead = this.getReadableDatabase();
        Cursor cursor = dbRead.query(DbConstants.TABLE_USERS, new String[]{DbConstants.COLUMN_USERNAME}, "first_name = ?", new String[]{username}, null, null, null);
        int columnUsernameIndex = cursor.getColumnIndex(DbConstants.COLUMN_USERNAME);
        String a = cursor.getString(columnUsernameIndex);
        cursor.close();
        dbRead.close();
        return a;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DbConstants.TABLE_UDACITY);
        db.execSQL("DROP TABLE IF EXISTS " + DbConstants.TABLE_COURSEA);
        db.execSQL("DROP TABLE IF EXISTS " + DbConstants.TABLE_USERS);
        onCreate(db);
    }
}
