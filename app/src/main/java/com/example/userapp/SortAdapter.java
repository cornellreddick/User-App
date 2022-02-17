package com.example.userapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class SortAdapter extends ArrayAdapter<String> {
    int order = -1;
    Button button;
    public SortAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> category) {
        super(context, resource, category);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_sort_layout, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.sortItem = convertView.findViewById(R.id.sortItemTextView);

            convertView.setTag(viewHolder);
        }
        String cat = getItem(position);
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();


        viewHolder.sortItem.setText(cat);


        // Get ImageView
        ImageView sortAsc = (ImageView) convertView.findViewById(R.id.imageViewAsc);
        sortAsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        ImageView sortDesc = (ImageView) convertView.findViewById(R.id.imageViewDesc);
        sortDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Check if it is male or female and set the image
//        if(user.gender.equals("Male")){
//            image.setImageResource(R.drawable.avatar_male);
//        }else{
//            image.setImageResource(R.drawable.avatar_female);
//        }



        return convertView;
    }

    private  static  class ViewHolder{
        TextView sortItem;
//        TextView userStateTextView;
//        TextView userAgeTextView;
//        TextView userRelationshipTexView;
    }
}