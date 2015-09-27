package com.icaboalo.tabsdrawerretrofitwithbutternife.io.model;

import com.google.gson.annotations.SerializedName;
import com.icaboalo.tabsdrawerretrofitwithbutternife.domain.UdacityModel;

import java.util.ArrayList;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class SearchUdacityResponse {

    @SerializedName("courses")
    ArrayList<UdacityModel> courses;

    public ArrayList<UdacityModel> getCourses() {
        return courses;
    }
}
