package com.example.userapp;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.userapp.databinding.FragmentStateBinding;
import com.example.userapp.databinding.FragmentUserBinding;

import java.util.ArrayList;


public class UserFragment extends Fragment {
    FragmentUserBinding binding;
    ListView listView;
    ArrayAdapter arrayAdapter;
    UserAdapter userAdapter;
    ArrayList<DataServices.User> users = DataServices.getAllUsers();


    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentUserBinding.inflate(inflater, container, false);

        listView = binding.listViewUser;
        userAdapter = new UserAdapter(getActivity(),R.layout.user_data_layout, users);
        listView.setAdapter(userAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return binding.getRoot();
    }

}