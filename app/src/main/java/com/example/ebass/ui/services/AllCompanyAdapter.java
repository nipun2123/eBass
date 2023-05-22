package com.example.ebass.ui.services;

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

public class AllCompanyAdapter extends ArrayAdapter<AllCompanyModel> {


    private static class ViewHolder{
        ImageView companyPic;
        TextView companyName,companyCate,companyLoaction,companyCode;
        RatingBar companyRate;
    }

    public AllCompanyAdapter(@NonNull Context context, @NonNull ArrayList<AllCompanyModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        AllCompanyModel companyModel = getItem(position);

        final ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.all_company_item,parent,false);
            viewHolder.companyPic = (ImageView) convertView.findViewById(R.id.allCompanyPic);
            viewHolder.companyName = (TextView) convertView.findViewById(R.id.allCompanyName);
            viewHolder.companyCate = (TextView) convertView.findViewById(R.id.allCompanyCate);
            viewHolder.companyLoaction = (TextView) convertView.findViewById(R.id.allCompanyLoca);
            viewHolder.companyRate = (RatingBar) convertView.findViewById(R.id.allCompanyRate);
            viewHolder.companyCode = (TextView) convertView.findViewById(R.id.allCompanyCode);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.companyPic.setImageResource(companyModel.getCompanyPic());
        viewHolder.companyName.setText(companyModel.getCompanyName());
        viewHolder.companyCate.setText(companyModel.getCompanyCategory());
        viewHolder.companyLoaction.setText(companyModel.getCompanyLocation());
        viewHolder.companyRate.setRating(companyModel.getCompanyRate());
        viewHolder.companyCode.setText(companyModel.getCompanyCode());
        viewHolder.companyCode.setVisibility(View.GONE);


        return convertView;
    }


}
