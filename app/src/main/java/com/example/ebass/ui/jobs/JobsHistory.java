package com.example.ebass.ui.jobs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import com.example.ebass.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class JobsHistory extends ListFragment {

    ArrayList<JobsModel> jobsList = new ArrayList<JobsModel>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_jobs_history, container, false);



        try {
            JobsModel jobsModel1 = new JobsModel().setJobId(3).setJobCategory("Plumping").setJobRequestDate(new SimpleDateFormat("HH:mm aa, dd-MMM-yyyy").parse("9:35 PM, 15-June-2019")).setStatus(4);
            JobsModel jobsModel2 = new JobsModel().setJobId(2).setJobCategory("Cleaning").setJobRequestDate(new SimpleDateFormat("HH:mm aa, dd-MMM-yyyy").parse("2:00 PM, 13-June-2018")).setStatus(0);
            JobsModel jobsModel3 = new JobsModel().setJobId(1).setJobCategory("Painting").setJobRequestDate(new SimpleDateFormat("HH:mm aa, dd-MMM-yyyy").parse("11:14 PM, 05-June-2018")).setStatus(4);

            jobsList.clear();
            jobsList.add(jobsModel1);
            jobsList.add(jobsModel2);
            jobsList.add(jobsModel3);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        JobsAdapter jobsAdapter = new JobsAdapter(getActivity(),jobsList);

        setListAdapter(jobsAdapter);

return v;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {


        Bundle args = new Bundle();
        args.putString("jobId", ((TextView)v.findViewById(R.id.jobId)).getText().toString());

        JobsProfile jobsProfile = new JobsProfile();
        jobsProfile.setArguments(args);


        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, jobsProfile);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
