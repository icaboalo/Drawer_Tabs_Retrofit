package com.icaboalo.tabsdrawerretrofitwithbutternife.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class CourseraModel {

    @SerializedName("name")
    String courseName;

    @SerializedName("id")
    String courseId;

    @SerializedName("photo")
    String courseImage;

    @SerializedName("shortDescription")
    String courseDescription;

    public String getCourseName() {
        return courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseImage() {

        return courseImage;
    }

    public String getCourseDescription() {
        return courseDescription;
    }
}
