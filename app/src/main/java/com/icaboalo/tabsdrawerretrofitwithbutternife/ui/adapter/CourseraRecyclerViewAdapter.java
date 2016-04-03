package com.icaboalo.tabsdrawerretrofitwithbutternife.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icaboalo.tabsdrawerretrofitwithbutternife.R;
import com.icaboalo.tabsdrawerretrofitwithbutternife.domain.CourseraModel;

import java.util.List;

/**
 * Created by icaboalo on 9/26/2015.
 */
public class CourseraRecyclerViewAdapter extends RecyclerView.Adapter<CourseraRecyclerViewAdapter.CourseraViewHolder>{

    Context mContext;
    LayoutInflater mInflater;
    List<CourseraModel> mCourseList;

    public CourseraRecyclerViewAdapter(Context context, List<CourseraModel> courseList) {
        mContext = context;
        mCourseList = courseList;
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<CourseraModel> newList){
        mCourseList = newList;
        notifyDataSetChanged();
    }

    @Override
    public CourseraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_row, parent, false);
        CourseraViewHolder viewHolder = new CourseraViewHolder(view, R.id.title_text, R.id.subtitle_text, R.id.description_text, R.id.image);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CourseraViewHolder holder, int position) {
        CourseraModel course = mCourseList.get(position);
        holder.setCourseName(course.getCourseName());
        holder.setCourseId(course.getCourseId());
        holder.setCourseDescription(course.getCourseDescription());
        holder.setCourseImage(course.getCourseImage());
    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }

    public class CourseraViewHolder extends RecyclerView.ViewHolder{

        TextView mCourseName, mCourseId, mCourseDescription;
        ImageView mCourseImage;

        public CourseraViewHolder(View itemView, int courseNameId, int courseIdId, int courseDescriptionId, int courseImageId) {
            super(itemView);
            mCourseName = (TextView) itemView.findViewById(courseNameId);
            mCourseId = (TextView) itemView.findViewById(courseIdId);
            mCourseDescription = (TextView) itemView.findViewById(courseDescriptionId);
            mCourseImage = (ImageView) itemView.findViewById(courseImageId);
        }

        public void setCourseName(String courseName) {
            this.mCourseName.setText(courseName);
        }

        public void setCourseId(String courseId) {
            this.mCourseId.setText(courseId);
        }

        public void setCourseDescription(String courseDescription){
            mCourseDescription.setText(courseDescription);
        }

        public void setCourseImage(String courseImage) {
//            Picasso.with(mContext).load(courseImage).placeholder(R.mipmap.ic_launcher).into(mCourseImage);
        }
    }
}
