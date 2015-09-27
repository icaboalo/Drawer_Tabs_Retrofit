package com.icaboalo.tabsdrawerretrofitwithbutternife.sqlite;

import android.content.Context;
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DbConstants.TABLE_UDACITY);
        db.execSQL("DROP TABLE IF EXISTS " + DbConstants.TABLE_COURSEA);
        onCreate(db);
    }
}
