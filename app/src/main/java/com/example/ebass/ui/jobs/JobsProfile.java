package com.example.ebass.ui.jobs;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.ebass.R;
import com.kofigyan.stateprogressbar.StateProgressBar;

public class JobsProfile extends Fragment {


    String[] descriptionData1 = {"Requested", "Accepted", "Working", "Done"};
    String[] descriptionData2 = {"Requested", "Rejected", "Working", "Done"};

    StateProgressBar stateProgressBar;
    TextView companyName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.jobs_profile, container, false);

        stateProgressBar = (StateProgressBar) v.findViewById(R.id.your_state_progress_bar_id);
        companyName = (TextView) v.findViewById(R.id.companyName);

        stateProgressBar.setStateDescriptionData(descriptionData1);

        String jobId = getArguments().getString("jobId");


        if(jobId.equalsIgnoreCase("1")){
                companyName.setText("Jepse");
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);

        }else if(jobId.equalsIgnoreCase("2")){
            companyName.setText("Helvon");
            stateProgressBar.setStateDescriptionData(descriptionData2);
            stateProgressBar.setCurrentStateDescriptionColor(ContextCompat.getColor(getActivity(), R.color.reject_state));
            stateProgressBar.setForegroundColor(ContextCompat.getColor(getActivity(), R.color.reject_state));
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);


        }else if(jobId.equalsIgnoreCase("3")){
            companyName.setText("Selth");
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
        }



        return v;

    }
}
