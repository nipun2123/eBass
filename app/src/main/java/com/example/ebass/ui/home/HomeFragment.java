package com.example.ebass.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.ebass.R;

public class HomeFragment extends Fragment {

    CardView electricalCard;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_home, container, false);

        electricalCard = (CardView) v.findViewById(R.id.electricalCard);
        electricalCard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getActivity(), Problem_RequestDetails.class).putExtra("job","electrical"));
           }
       });

       return v;
    }


}