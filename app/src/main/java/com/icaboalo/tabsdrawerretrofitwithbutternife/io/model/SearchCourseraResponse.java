package com.icaboalo.tabsdrawerretrofitwithbutternife.io.model;

import com.google.gson.annotations.SerializedName;
import com.icaboalo.tabsdrawerretrofitwithbutternife.domain.CourseraModel;

import java.util.ArrayList;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class SearchCourseraResponse {

    @SerializedName("elements")
    ArrayList<CourseraModel> courseList;

    public ArrayList<CourseraModel> getCourseList() {
        return courseList;
    }
}
