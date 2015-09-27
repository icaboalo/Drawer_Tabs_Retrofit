package com.icaboalo.tabsdrawerretrofitwithbutternife.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.icaboalo.tabsdrawerretrofitwithbutternife.domain.ModelFramentPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {


    List<ModelFramentPager> mPagerList = new ArrayList<>();
    Context mContext;

    public MyViewPagerAdapter(FragmentManager fm, List<ModelFramentPager> pagerList) {
        super(fm);
        this.mPagerList = pagerList;
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        return mPagerList.get(position).getPager();
    }

    @Override
    public int getCount() {
        return mPagerList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPagerList.get(position).getTitle();
    }
}
