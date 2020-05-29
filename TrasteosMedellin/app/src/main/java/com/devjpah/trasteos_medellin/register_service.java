package com.devjpah.trasteos_medellin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import es.dmoral.toasty.Toasty;


public class register_service extends Fragment {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    EditText etTipoVehiculo, etCiudadCargue, etDireccionCargue, etCiudadDescargue, etDireccionDescargue, etEmail, etFechaHora, etDescripcion, etTipoServicio;
    EditText etPrecio, etEstado;
    Button btnIngresar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_register_service, container, false);
        etTipoVehiculo = root.findViewById(R.id.etTipoVehiculo);
        etCiudadCargue = root.findViewById(R.id.etCiudadCargue);
        etDireccionCargue = root.findViewById(R.id.etDireccionCarga);
        etCiudadDescargue = root.findViewById(R.id.etCiudadDescargue);
        etDireccionDescargue = root.findViewById(R.id.etDireccionDescargue);
        etEmail = root.findViewById(R.id.etEmail);
        etFechaHora = root.findViewById(R.id.etFechaHora);
        etDescripcion = root.findViewById(R.id.etDescripcion);
        etTipoServicio = root.findViewById(R.id.etTipoServicio);
        etPrecio = root.findViewById(R.id.etPrecio);
        etEstado = root.findViewById(R.id.etEstado);
        btnIngresar = root.findViewById(R.id.btnIngresarNS);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*agregarDatos();
                LimpiarCampos();*/
                Toasty.success(getContext(),"MElosososos", Toasty.LENGTH_LONG).show();
            }
        });
        return root;
    }
}
