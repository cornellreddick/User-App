package com.example.userapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.userapp.databinding.FragmentStateBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class StateFragment extends Fragment {
    ListView listView;
    ArrayAdapter arrayAdapter;
    FragmentStateBinding binding;
    ArrayList<DataServices.User> users = DataServices.getAllUsers();
    String StateFragmentLister;
    int order =  -1;


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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String stateSelected = arrayAdapter.getItem(position).toString();

                UserFragment userFragment = new UserFragment();
                Bundle bundle = new Bundle();
                bundle.putString("stateSelected", stateSelected);
      //          findUsingEnhancedForLoop(stateSelected, users);

                userFragment.setArguments(bundle);
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.containerView, userFragment).commit();


//                Collections.sort(users, new Comparator<DataServices.User>() {
//                    @Override
//                    public int compare(DataServices.User u1, DataServices.User u2) {
//                        order = order * (-1);
//                        r
//                    }
//                });


                arrayAdapter.notifyDataSetChanged();


            }
        });
    }
    public DataServices.User findUsingEnhancedForLoop(
            String state, ArrayList<DataServices.User> users) {

        for (DataServices.User user : users) {
            if (!user.state.equals(state)) {
                return user;
            }
        }
        return null;
    }
}
