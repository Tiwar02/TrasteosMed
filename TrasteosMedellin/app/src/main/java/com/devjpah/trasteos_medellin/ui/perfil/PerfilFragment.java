package com.devjpah.trasteos_medellin.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.devjpah.trasteos_medellin.R;

import es.dmoral.toasty.Toasty;

public class PerfilFragment extends Fragment {

    EditText et_doc, et_nombre, et_fecha, et_telefono, et_email, et_contraseña;
    Button btnActualizar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        et_doc = view.findViewById(R.id.et_doc);
        et_nombre = view.findViewById(R.id.et_nombre);
        et_fecha = view.findViewById(R.id.et_fecha);
        et_telefono = view.findViewById(R.id.et_telefono);
        et_email = view.findViewById(R.id.et_email);
        et_contraseña = view.findViewById(R.id.et_contraseña);
        btnActualizar = view.findViewById(R.id.btnActualizar);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.success(getContext(),"Melisimos", Toasty.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}