package com.icaboalo.tabsdrawerretrofitwithbutternife.io;

import com.icaboalo.tabsdrawerretrofitwithbutternife.constants.CourseraConstants;
import com.icaboalo.tabsdrawerretrofitwithbutternife.constants.UdacityConstants;
import com.icaboalo.tabsdrawerretrofitwithbutternife.io.model.SearchCourseraResponse;
import com.icaboalo.tabsdrawerretrofitwithbutternife.io.model.SearchUdacityResponse;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class ApiClient {

//    udacity api
    private static ApiService udacityApiService;

    public static ApiService getUdacityApiService(){
        if (udacityApiService == null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(UdacityConstants.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            udacityApiService = restAdapter.create(ApiService.class);
        }
        return udacityApiService;
    }

    public static void searchUdacityCourse(Callback<SearchUdacityResponse> udacityApiResponse){
        getUdacityApiService().searchUdacityCourse(udacityApiResponse);
    }


//    coursera api
    private static ApiService courseraApiService;
    public static ApiService getCourseraApiService(){
        if (courseraApiService == null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(CourseraConstants.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            courseraApiService = restAdapter.create(ApiService.class);
        }
        return courseraApiService;
    }

    public static void searchCourseraCourse(String query, Callback<SearchCourseraResponse> courseraApiResponse){
        getCourseraApiService().searchCourseraCourse(query, courseraApiResponse);
    }


}
