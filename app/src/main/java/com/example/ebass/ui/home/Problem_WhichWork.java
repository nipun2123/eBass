package com.example.ebass.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ebass.R;

import java.util.ArrayList;

public class Problem_WhichWork extends Fragment {

    ListView answersList;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String>  answers = new ArrayList<String>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.problem_which_work, container, false);

        answersList = (ListView) v.findViewById(R.id.workAnswersList);

//        answersList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        answers.clear();
        answers.add("Not Selected");
        answers.add("Installations");
        answers.add("Repair");
        answers.add("Replace");
        answers.add("Remove");
        answers.add("Other");


//        arrayAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_single_choice, answers);

        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        answersList.setAdapter(arrayAdapter);

        answersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value =  (String)parent.getItemAtPosition(position);
                Toast.makeText(getActivity(),value,Toast.LENGTH_LONG).show();
            }
        });
    }
}
