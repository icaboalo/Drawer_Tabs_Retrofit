package com.icaboalo.tabsdrawerretrofitwithbutternife.constants;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class CourseraConstants {
    public static final String BASE_URL = "https://api.coursera.org/api/catalog.v1";
    public static final String PATH_COURSES = "/courses";
    public static final String ARG_TYPE = "q";
    public static final String VALUE_SEARCH = "search";
    public static final String ARG_FIELD = "fields";
    public static final String VALUE_SHORT_DESCRIPTION = "shortDescription";
    public static final String VALUE_PHOTO = "photo";
    public static final String  ARG_QUERY = "query";
    public static final String URL_SEARCH_COURSE =
            PATH_COURSES +
                    "?" +
                    ARG_TYPE +
                    "=" +
                    VALUE_SEARCH +
                    "&" +
                    ARG_FIELD +
                    "=" +
                    VALUE_SHORT_DESCRIPTION +
                    "," +
                    VALUE_PHOTO;

}
