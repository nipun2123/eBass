package com.example.ebass.ui.jobs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ebass.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class JobsAdapter extends ArrayAdapter<JobsModel> {

    private final static int REQUESTED = 1;
    private final static int ACCEPTED = 2;
    private final static int WORKING = 3;
    private final static int DONE = 4;
    private final static int REJECTED = 0;

    private static class ViewHolder{

        TextView jobId,jobCategory,jobRequestDate,jobState;
    }

    public JobsAdapter(@NonNull Context context, @NonNull ArrayList<JobsModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        JobsModel jobsModel = getItem(position);

        final JobsAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new JobsAdapter.ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.jobs_view_item, parent, false);
            viewHolder.jobCategory = (TextView) convertView.findViewById(R.id.jobCategory);
            viewHolder.jobRequestDate = (TextView) convertView.findViewById(R.id.jobRequestDate);
            viewHolder.jobState = (TextView) convertView.findViewById(R.id.jobState);
            viewHolder.jobId = (TextView) convertView.findViewById(R.id.jobId);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (JobsAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.jobId.setVisibility(View.GONE);
        viewHolder.jobId.setText(String.valueOf(jobsModel.getJobId()));
        viewHolder.jobCategory.setText(jobsModel.getJobCategory());
        viewHolder.jobRequestDate.setText(new SimpleDateFormat("HH:mm aa, dd-MMM-yyyy").format(jobsModel.getJobRequestDate()));
        switch (jobsModel.getStatus()){
            case JobsAdapter.REQUESTED:
                viewHolder.jobState.setText("Requested");
                break;
            case JobsAdapter.ACCEPTED:
                viewHolder.jobState.setText("Accepted");
                break;
            case JobsAdapter.WORKING:
                viewHolder.jobState.setText("Working");
                break;
            case JobsAdapter.DONE:
                viewHolder.jobState.setText("Done");
                break;

            case JobsAdapter.REJECTED:
                viewHolder.jobState.setText("Rejected");
                break;
        }
        return convertView;
    }

}
