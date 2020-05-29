package com.devjpah.trasteos_medellin.ui.newservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.devjpah.trasteos_medellin.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewServiceFragment extends Fragment {
   ImageButton imgExpress;
    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
   FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_new_service, container, false);
        imgExpress = root.findViewById(R.id.btnExpress);
        imgExpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        fragmentTransaction.replace(R.id.nav_host_fragment, new fragment)
                startActivity();
            }
        });
        return root;
    }
}