package com.icaboalo.tabsdrawerretrofitwithbutternife.io;

import com.icaboalo.tabsdrawerretrofitwithbutternife.constants.CourseraConstants;
import com.icaboalo.tabsdrawerretrofitwithbutternife.constants.UdacityConstants;
import com.icaboalo.tabsdrawerretrofitwithbutternife.io.model.SearchCourseraResponse;
import com.icaboalo.tabsdrawerretrofitwithbutternife.io.model.SearchUdacityResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by icaboalo on 9/26/2015.
 */
public interface ApiService {
    @GET(UdacityConstants.PATH_COURSE)
    void searchUdacityCourse(Callback<SearchUdacityResponse> udacityApiResposnse);

    @GET(CourseraConstants.URL_SEARCH_COURSE)
    void searchCourseraCourse(@Query(CourseraConstants.ARG_QUERY)String course, Callback<SearchCourseraResponse> courseraApiResponse);
}
