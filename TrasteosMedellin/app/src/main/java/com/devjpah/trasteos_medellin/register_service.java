package com.devjpah.trasteos_medellin;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import es.dmoral.toasty.Toasty;


public class register_service extends Fragment {
    FirebaseDatabase database;
    DatabaseReference myRef;
    EditText etTipoVehiculo, etCiudadCargue, etDireccionCargue, etCiudadDescargue, etDireccionDescargue, etEmail, etFechaHora, etDescripcion, etTipoServicio;
    EditText etPrecio, etEstado;
    Button btnIngresar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_register_service, container, false);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
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
    public void agregarDatos()
    {
        Toasty.error(getContext(),"Error",Toasty.LENGTH_LONG).show();
        Random rnd = new Random();
        int randon = rnd.nextInt(100)*900;
        String id = "tr-"+ randon;
        String vehiculo = etTipoVehiculo.getText().toString();
        String ciudadCar = etCiudadCargue.getText().toString();
        String direccionCar = etDireccionCargue.getText().toString();
        String ciudadDes = etCiudadDescargue.getText().toString();
        String direccionDes = etDireccionDescargue.getText().toString();
        String email = etEmail.getText().toString();
        String FechaHora= etFechaHora.getText().toString();
        String desc = etDescripcion.getText().toString();
        String tipoServicio = etTipoServicio.getText().toString();
        String precio = etPrecio.getText().toString();
        String estado = etEstado.getText().toString();
        //Agregar FireBase
        Map<String, Object> datos = new HashMap<>();
        datos.put("Id", id);
        datos.put("TipoVehiculo", vehiculo);
        datos.put("CiudadCargue", ciudadCar);
        datos.put("DireccionCargue", direccionCar);
        datos.put("CiudadDescargue",ciudadDes);
        datos.put("DireccionDescargue", direccionDes);
        datos.put("EmailUsuario", email);
        datos.put("FechaHora", FechaHora);
        datos.put("Descripcion", desc);
        datos.put("TipoServicio", tipoServicio);
        datos.put("Precio", precio);
        datos.put("Estado", estado);
        myRef.child("Trasteos").push().setValue(datos);
        //Agregar BD


    }

    /*public void Conectar()
    {
        etTipoVehiculo = getView().findViewById(R.id.etTipoVehiculo);
        etCiudadCargue = getView().findViewById(R.id.etCiudadCargue);
        etDireccionCargue = getView().findViewById(R.id.etDireccionCarga);
        etCiudadDescargue = getView().findViewById(R.id.etCiudadDescargue);
        etDireccionDescargue = getView().findViewById(R.id.etDireccionDescargue);
        etEmail = getView().findViewById(R.id.etEmail);
        etFechaHora = getView().findViewById(R.id.etFechaHora);
        etDescripcion = getView().findViewById(R.id.etDescripcion);
        etTipoServicio = getView().findViewById(R.id.etTipoServicio);
        etPrecio = getView().findViewById(R.id.etPrecio);
        etEstado = getView().findViewById(R.id.etEstado);
        btnIngresar = getView().findViewById(R.id.btnIngresarNS);
    }*/

    public void aggBD ()
    {
        Random rnd = new Random();
        int randon = rnd.nextInt(100)*900;
        String id = "tr-"+ randon;
        String vehiculo = etTipoVehiculo.getText().toString();
        String ciudadCar = etCiudadCargue.getText().toString();
        String direccionCar = etDireccionCargue.getText().toString();
        String ciudadDes = etCiudadDescargue.getText().toString();
        String direccionDes = etDireccionDescargue.getText().toString();
        String email = etEmail.getText().toString();
        String FechaHora= etFechaHora.getText().toString();
        String desc = etDescripcion.getText().toString();
        String tipoServicio = etTipoServicio.getText().toString();
        String precio = etPrecio.getText().toString();
        String estado = etEstado.getText().toString();
        DbHelper helper = new DbHelper(getContext(), "BD", null, 1);
        SQLiteDatabase db =helper.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put("Id", id);
            cv.put("TipoVehiculo", vehiculo);
            cv.put("CiudadCargue", ciudadCar);
            cv.put("DireccionCargue", direccionCar);
            cv.put("CiudadDescargue",ciudadDes);
            cv.put("DireccionDescargue", direccionDes);
            cv.put("EmailUsuario", email);
            cv.put("FechaHora", FechaHora);
            cv.put("Descripcion", desc);
            cv.put("TipoServicio", tipoServicio);
            cv.put("Precio", precio);
            cv.put("Estado", estado);
            db.insert("Trasteos", null, cv);
            db.close();
            Toast.makeText(getContext(), "Trasteo Ingresado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex)
        {
            Toasty.error(getContext(),"Error",Toasty.LENGTH_LONG).show();
        }
    }
    public void LimpiarCampos()
    {
        etTipoVehiculo.setText("");
        etCiudadCargue.setText("");
        etDireccionCargue.setText("");
        etCiudadDescargue.setText("");
        etDireccionDescargue.setText("");
        etEmail.setText("");
        etFechaHora.setText("");
        etDescripcion.setText("");
        etTipoServicio.setText("");
        etPrecio.setText("");
        etEstado.setText("");

    }

    public void eliminarBD (String id)
    {
        DbHelper helper = new DbHelper(getContext(), "BD", null, 1);
        SQLiteDatabase bd = helper.getWritableDatabase();
        bd.delete("Trasteos", "Id="+id, null);
        Toast.makeText(getContext(), "Trasteo Eliminado", Toast.LENGTH_LONG).show();
    }

    public void updateBD(String id)
    {
        DbHelper helper = new DbHelper(getContext(), "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String vehiculo = etTipoVehiculo.getText().toString();
        String ciudadCar = etCiudadCargue.getText().toString();
        String direccionCar = etDireccionCargue.getText().toString();
        String ciudadDes = etCiudadDescargue.getText().toString();
        String direccionDes = etDireccionDescargue.getText().toString();
        String email = etEmail.getText().toString();
        String FechaHora= etFechaHora.getText().toString();
        String desc = etDescripcion.getText().toString();
        String tipoServicio = etTipoServicio.getText().toString();
        String precio = etPrecio.getText().toString();
        String estado = etEstado.getText().toString();
        try {
            ContentValues cv = new ContentValues();
            cv.put("TipoVehiculo", vehiculo);
            cv.put("CiudadCargue", ciudadCar);
            cv.put("DireccionCargue", direccionCar);
            cv.put("CiudadDescargue",ciudadDes);
            cv.put("DireccionDescargue", direccionDes);
            cv.put("EmailUsuario", email);
            cv.put("FechaHora", FechaHora);
            cv.put("Descripcion", desc);
            cv.put("TipoServicio", tipoServicio);
            cv.put("Precio", precio);
            cv.put("Estado", estado);
            db.update("BD", cv, "Id="+id, null);
            db.close();
            Toast.makeText(getContext(), "Trasteo Actualizado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex)
        {
            Toasty.error(getContext(),"Error",Toasty.LENGTH_LONG).show();
        }
    }
}
