package com.icaboalo.tabsdrawerretrofitwithbutternife.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icaboalo.tabsdrawerretrofitwithbutternife.R;
import com.icaboalo.tabsdrawerretrofitwithbutternife.domain.CourseraModel;
import com.icaboalo.tabsdrawerretrofitwithbutternife.io.ApiClient;
import com.icaboalo.tabsdrawerretrofitwithbutternife.io.model.SearchCourseraResponse;
import com.icaboalo.tabsdrawerretrofitwithbutternife.ui.adapter.CourseraRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class CourseraFragment extends Fragment {

    @Bind(R.id.course_list)
    RecyclerView mRecyclerView;

    @Bind(R.id.search_input)
    SearchView mSearchView;

    CourseraRecyclerViewAdapter mRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_search, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        setUpRecyclerView();
        searchListener();
        executeWithRetrofit("android");
    }

    private void searchListener() {
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                executeWithRetrofit(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerViewAdapter = new CourseraRecyclerViewAdapter(getActivity(), createCourse());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    List<CourseraModel> createCourse(){
        List<CourseraModel> courseList = new ArrayList<>();

        return courseList;
    }

    private void executeWithRetrofit(String query) {
        ApiClient.searchCourseraCourse(query, new Callback<SearchCourseraResponse>() {
            @Override
            public void success(SearchCourseraResponse searchCourseraResponse, Response response) {
                List<CourseraModel> newList = searchCourseraResponse.getCourseList();
                mRecyclerViewAdapter.setData(newList);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
