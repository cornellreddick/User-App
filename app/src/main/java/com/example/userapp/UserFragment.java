package com.example.userapp;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.userapp.databinding.FragmentStateBinding;
import com.example.userapp.databinding.FragmentUserBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;


public class UserFragment extends Fragment {
    FragmentUserBinding binding;
    ListView listView;
    ArrayAdapter arrayAdapter;
    UserAdapter userAdapter;
    String selectedStated;
    ArrayList<DataServices.User> users = DataServices.getAllUsers();
    ArrayList<DataServices.User> userslist = new ArrayList<>();
    int order = -1;


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
             Bundle bundle = getArguments();
        if (bundle != null){
           selectedStated = bundle.getString("stateSelected");
            if (selectedStated != null){
                getFilterByState(users, selectedStated);
                Toast.makeText(getActivity(), "Data Sent!", Toast.LENGTH_LONG).show();
            }
        }

        for (DataServices.User user: userslist) {
            if (!user.state.contains(selectedStated)){
                users.remove(user);

            }
        }

        listView = binding.listViewUser;
        userAdapter = new UserAdapter(getActivity(),R.layout.user_data_layout, users);
        listView.setAdapter(userAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                DataServices.User user = userAdapter.getItem(position);

                order = order * (-1);
                Collections.sort(users, new Comparator<DataServices.User>(){
                    public int compare(DataServices.User obj1, DataServices.User obj2) {
                            return order * obj1.state.compareTo(obj2.state); // To compare string values
                    }
                });

                userAdapter.notifyDataSetChanged();

            }
        });

        binding.userFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.containerView, new StateFragment())
                        .addToBackStack(null)
                        .commit();

            }
        });
        binding.userSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.containerView, new SortFragment())
                        .addToBackStack(null)
                        .commit();

            }
        });

        return binding.getRoot();
    }

    public  ArrayList<DataServices.User> getFilterByState(ArrayList<DataServices.User> users, String s){
        for (int i = 0; i < users.size() ; i++) {
            if (!users.get(i).state.contains(s.toLowerCase(Locale.ROOT)) || !users.get(i).state.contains(s.toUpperCase(Locale.ROOT))){
                users.remove(users.get(i));
            }
        }

        return users;
    }
}