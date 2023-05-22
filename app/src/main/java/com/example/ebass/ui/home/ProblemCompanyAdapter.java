package com.example.ebass.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ebass.R;

import java.util.ArrayList;

public class ProblemCompanyAdapter extends ArrayAdapter<ProblemCompanyModel> {

    CheckedTextView checkedItem;

    private static class ViewHolder{
        ImageView companyPic;
        TextView companyName,companyCate,companyLoaction;
        RatingBar companyRate;
    }

    public ProblemCompanyAdapter(@NonNull Context context, @NonNull ArrayList<ProblemCompanyModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ProblemCompanyModel companyModel = getItem(position);

        final ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.problem_company_item,parent,false);
            viewHolder.companyPic = (ImageView) convertView.findViewById(R.id.problemCompanyPic);
            viewHolder.companyName = (TextView) convertView.findViewById(R.id.problemCompanyName);
            viewHolder.companyCate = (TextView) convertView.findViewById(R.id.problemCompanyCate);
            viewHolder.companyLoaction = (TextView) convertView.findViewById(R.id.problemCompanyLoca);
            viewHolder.companyRate = (RatingBar) convertView.findViewById(R.id.problemCompanyRate);
            viewHolder.companyRate = (RatingBar) convertView.findViewById(R.id.problemCompanyRate);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.companyPic.setImageResource(companyModel.getCompanyPic());
        viewHolder.companyName.setText(companyModel.getCompanyName());
        viewHolder.companyCate.setText(companyModel.getCompanyCategory());
        viewHolder.companyLoaction.setText(companyModel.getCompanyLocation());
        viewHolder.companyRate.setRating(companyModel.getCompanyRate());

        return convertView;
    }


    public void setCheckItem(CheckedTextView component){
        if(checkedItem!=null){

        checkedItem.setChecked(false);
        }
        component.setChecked(true);
        checkedItem = component;
    }
}
