package com.example.userapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.userapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new StateFragment())
                .addToBackStack(null)
                .commit();
    }


}