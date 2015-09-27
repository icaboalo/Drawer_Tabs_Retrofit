package com.icaboalo.tabsdrawerretrofitwithbutternife.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icaboalo.tabsdrawerretrofitwithbutternife.R;
import com.icaboalo.tabsdrawerretrofitwithbutternife.domain.UdacityModel;
import com.icaboalo.tabsdrawerretrofitwithbutternife.io.ApiClient;
import com.icaboalo.tabsdrawerretrofitwithbutternife.io.model.SearchUdacityResponse;
import com.icaboalo.tabsdrawerretrofitwithbutternife.ui.adapter.UdacityRecyclerViewAdapter;

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
public class UdacityFragment extends Fragment {

    @Bind(R.id.course_list)
    RecyclerView mRecyclerView;

    UdacityRecyclerViewAdapter recyclerViewAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setUpRecyclerView();
    }

    @Override
    public void onResume() {
        super.onResume();
        executeWithRetrofit();
    }

    private void executeWithRetrofit() {
        ApiClient.searchUdacityCourse(new Callback<SearchUdacityResponse>() {
            @Override
            public void success(SearchUdacityResponse searchUdacityResponse, Response response) {
                List<UdacityModel> newCourseList = searchUdacityResponse.getCourses();
                recyclerViewAdapter.setData(newCourseList);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewAdapter = new UdacityRecyclerViewAdapter(getActivity(), createCourse());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    public List<UdacityModel> createCourse(){
        List<UdacityModel> courseList = new ArrayList<>();
        courseList.add(new UdacityModel());

        return courseList;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
