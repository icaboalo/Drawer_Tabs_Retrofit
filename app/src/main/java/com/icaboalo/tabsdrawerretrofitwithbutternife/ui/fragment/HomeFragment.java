package com.icaboalo.tabsdrawerretrofitwithbutternife.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icaboalo.tabsdrawerretrofitwithbutternife.R;
import com.icaboalo.tabsdrawerretrofitwithbutternife.domain.ModelFramentPager;
import com.icaboalo.tabsdrawerretrofitwithbutternife.ui.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class HomeFragment extends Fragment {

    @Bind(R.id.tabs_layout)
    TabLayout mTabLayout;

    @Bind(R.id.pager)
    ViewPager mPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpTabs();
    }

    private void setUpTabs() {
        MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(), createPager());
        mPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mPager);
    }

    private List<ModelFramentPager> createPager() {
        List<ModelFramentPager> modelFramentPagerList = new ArrayList<>();
        modelFramentPagerList.add(new ModelFramentPager(new UdacityFragment(), "Udacity"));
        modelFramentPagerList.add(new ModelFramentPager(new CourseraFragment(), "Coursera"));

        return modelFramentPagerList;
    }
}
