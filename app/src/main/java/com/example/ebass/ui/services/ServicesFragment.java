package com.example.ebass.ui.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ebass.R;
import com.example.ebass.ui.home.ProblemCompanyAdapter;
import com.example.ebass.ui.home.ProblemCompanyModel;

import java.util.ArrayList;

public class ServicesFragment extends Fragment {


    ArrayList<AllCompanyModel> companyModels = new ArrayList<AllCompanyModel>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_services, container, false);


        companyModels.clear();
        ListView compamyList = v.findViewById(R.id.allCompanyList);
        companyModels.add(new AllCompanyModel("6",R.drawable.test1,"Tecla","Electrical","Kadawatha",5.0f));
        companyModels.add(new AllCompanyModel("5",R.drawable.test2,"Fixma","Electrical","Kiribathgoda",3.5f));
        companyModels.add(new AllCompanyModel("4",R.drawable.test3,"Delo","Electrical","Biyagama",3.0f));
        companyModels.add(new AllCompanyModel("3",R.drawable.test4,"Jepse","Electrical","Kottawa",2.5f));
        companyModels.add(new AllCompanyModel("2",R.drawable.test5,"Helvon","Electrical","Maharagama",2.0f));
        companyModels.add(new AllCompanyModel("1",R.drawable.test1,"Selth","Electrical","Pnadura",1.5f));

        final AllCompanyAdapter companySearchAdapter = new AllCompanyAdapter(getActivity(),companyModels);
        compamyList.setAdapter(companySearchAdapter);


        compamyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle args = new Bundle();
                args.putString("companyCode", ((TextView)view.findViewById(R.id.allCompanyCode)).getText().toString());

                CompanyProfile companyProfile = new CompanyProfile();
                companyProfile.setArguments(args);


                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, companyProfile);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

return v;

    }
}