package com.example.userapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserAdapter extends ArrayAdapter<DataServices.User> {
    int order = -1;
    List<DataServices.User> GetAll;
    Button button;
    public UserAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DataServices.User> user) {
        super(context, resource, user);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_data_layout, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.userNameTextView = convertView.findViewById(R.id.userNameTextView);
            viewHolder.userStateTextView = convertView.findViewById(R.id.userStateTextView);
            viewHolder.userAgeTextView = convertView.findViewById(R.id.userAgeTextView);
            viewHolder.userRelationshipTexView = convertView.findViewById(R.id.userRelationshipTexView);
            convertView.setTag(viewHolder);
        }
       DataServices.User user = getItem(position);
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();


        viewHolder.userNameTextView.setText(user.name);
        viewHolder.userStateTextView.setText(user.state);
        viewHolder.userAgeTextView.setText(String.valueOf(user.age));
        viewHolder.userRelationshipTexView.setText(user.group);

        // Get ImageView
        ImageView image = (ImageView) convertView.findViewById(R.id.genderImageView);

        // Check if it is male or female and set the image
        if(user.gender.equals("Male")){
            image.setImageResource(R.drawable.avatar_male);
        }else{
            image.setImageResource(R.drawable.avatar_female);
        }



        return convertView;
    }

    private  static  class ViewHolder{
        TextView userNameTextView;
        TextView userStateTextView;
        TextView userAgeTextView;
        TextView userRelationshipTexView;
    }
}
