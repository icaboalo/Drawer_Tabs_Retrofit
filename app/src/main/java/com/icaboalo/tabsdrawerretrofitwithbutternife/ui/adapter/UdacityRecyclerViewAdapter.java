package com.icaboalo.tabsdrawerretrofitwithbutternife.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icaboalo.tabsdrawerretrofitwithbutternife.R;
import com.icaboalo.tabsdrawerretrofitwithbutternife.domain.UdacityModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class UdacityRecyclerViewAdapter extends RecyclerView.Adapter<UdacityRecyclerViewAdapter.UdacityViewHolder>{

    List<UdacityModel> mCourseList;
    Context mContext;
    LayoutInflater mInflater;



    public UdacityRecyclerViewAdapter(Context context, List<UdacityModel> courseList) {
        mContext = context;
        mCourseList = courseList;
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<UdacityModel> newData){
        mCourseList = newData;
        notifyDataSetChanged();
    }

    @Override
    public UdacityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_row ,parent, false);
        UdacityViewHolder viewHolder = new UdacityViewHolder(view,
                R.id.title_text,
                R.id.description_text,
                R.id.subtitle_text,
                R.id.image);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UdacityViewHolder holder, int position) {
        UdacityModel course = mCourseList.get(position);
        holder.setCourseName(course.getCourseTitle());
        holder.setCourseDescription(course.getCourseDescription());
        holder.setCourseLevel(course.getCourseLevel());
        holder.setCourseImage(course.getCourseImage());
    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }

    public class UdacityViewHolder extends RecyclerView.ViewHolder{

        TextView mCourseName, mCourseDescription, mCourseLevel;
        ImageView mCourseImage;

        public UdacityViewHolder(View itemView, int mCourseNameId, int mCourseDescriptionId, int mCourseLevelId, int mCourseImageId) {
            super(itemView);
            mCourseName = (TextView) itemView.findViewById(mCourseNameId);
            mCourseDescription = (TextView) itemView.findViewById(mCourseDescriptionId);
            mCourseLevel = (TextView) itemView.findViewById(mCourseLevelId);
            mCourseImage = (ImageView) itemView.findViewById(mCourseImageId);
        }

        public void setCourseName(String courseName) {
            mCourseName.setText(courseName);
        }

        public void setCourseDescription(String courseDescription) {
            mCourseDescription.setText(courseDescription);
        }

        public void setCourseLevel(String courseLevel) {
            mCourseLevel.setText(courseLevel);
        }

        public void setCourseImage(String courseImage) {
            Picasso.with(mContext).load(courseImage).into(mCourseImage);
        }
    }
}
