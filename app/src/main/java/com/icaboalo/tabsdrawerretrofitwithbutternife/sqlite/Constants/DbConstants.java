package com.icaboalo.tabsdrawerretrofitwithbutternife.sqlite.Constants;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class DbConstants {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "courses.db";

    public static final String TABLE_UDACITY = "udacity";
    public static final String TABLE_COURSEA = "coursea";
    public static final String TABLE_USERS = "users";

//    users columns
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";

    //    udacity and coursea columns
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "course_title";
    public static final String COLUMN_DESCRIPTION = "course_description";
    public static final String COLUMN_IMAGE = "course_image";

    //    udacity columns
    public static final String COLUMN_LEVEL = "course_level";

    //    coursea columns
    public static final String COLUMN_LANGUAGE = "course_language";


    //    create udacity table
    public static final String CREATE_TABLE_UDACITY =
            "CREATE TABLE " + TABLE_UDACITY + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_LEVEL + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT, " +
                    COLUMN_IMAGE + " TEXT);";

    //    create coursea table
    public static final String CREATE_TABLE_COURSEA =
            "CREATE TABLE " + TABLE_COURSEA + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_LANGUAGE + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT, " +
                    COLUMN_IMAGE + " TEXT);";


//    create users table
    public static final String CREATE_TABLE_USERS =
        "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FIRST_NAME + " TEXT, " +
                COLUMN_LAST_NAME + " TEXT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT);";
}
