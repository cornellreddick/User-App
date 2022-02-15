package com.example.userapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<DataServices.User> {
    public UserAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DataServices.User> user) {
        super(context, resource, user);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_data_layout, parent, false);
        }
       DataServices.User user = getItem(position);

        TextView userNameTextView = convertView.findViewById(R.id.userNameTextView);
        TextView userStateTextView = convertView.findViewById(R.id.userStateTextView);
        TextView userAgeTextView = convertView.findViewById(R.id.userAgeTextView);
        TextView userRelationshipTexView = convertView.findViewById(R.id.userRelationshipTexView);



        userNameTextView.setText(user.name);
        userStateTextView.setText(user.state);
        userAgeTextView.setText(String.valueOf(user.age));
        userRelationshipTexView.setText(user.group);

        // Get ImageView
        ImageView image = (ImageView) convertView.findViewById(R.id.genderImageView);

        // Check if it is male or female and set the image
        if(user.gender.equals("Male")){
            image.setImageResource(R.drawable.avatar_male);
        }else{
            image.setImageResource(R.drawable.avatar_male);
        }



        return convertView;
    }
}
