package com.example.ebass.ui.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ebass.R;

public class CompanyProfile extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.company_profile, container, false);


        String companyCode = getArguments().getString("companyCode");


        if(companyCode.equalsIgnoreCase("1")){

        }else  if(companyCode.equalsIgnoreCase("2")){

        }else  if(companyCode.equalsIgnoreCase("3")){

        }else  if(companyCode.equalsIgnoreCase("4")){

        }else  if(companyCode.equalsIgnoreCase("5")){

        }else  if(companyCode.equalsIgnoreCase("6")){

        }

return v;
    }


    }
