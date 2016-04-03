package com.icaboalo.tabsdrawerretrofitwithbutternife.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class UdacityModel {

    @SerializedName("title")
    String courseTitle;

    @SerializedName("image")
    String courseImage;

    @SerializedName("short_summary")
    String courseDescription;

    @SerializedName("level")
    String courseLevel;

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getCourseLevel() {
        return courseLevel;
    }
}
