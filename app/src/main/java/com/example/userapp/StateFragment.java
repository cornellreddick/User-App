package com.example.userapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.userapp.databinding.FragmentStateBinding;

import java.util.ArrayList;


public class StateFragment extends Fragment {
    ListView listView;
    ArrayAdapter arrayAdapter;
    FragmentStateBinding binding;
    ArrayList<DataServices.User> users = DataServices.getAllUsers();


    public StateFragment() {
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
        binding = FragmentStateBinding.inflate(inflater, container, false);
        createListView();

        return binding.getRoot();
    }

    public void createListView(){
        listView = binding.stateListView;
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, users);
        listView.setAdapter(arrayAdapter);
    }
}
