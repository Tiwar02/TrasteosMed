package com.devjpah.trasteos_medellin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    String Trasteos = "Create table Trasteos (Id Integer Primary Key, tipoVehiculo text, ciudadCargue text, direccionCargue text, " +
            "ciudadDescargue text, direccionDescargue text,emailUsuario text, fechaHora text, descripcion text, tipoServicio text, Precio Integer, Estado text," +
            "Foreign Key(emailUsuario) references Clientes(Email))";
    String Clientes = "Create table Clientes (Cedula text not null, Nombres text not null,  " +
            "fechaNacimiento text, tipoUsuario text, Telefono Integer, Email text Primary Key not null, Contraseña text)";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Trasteos);
        db.execSQL(Clientes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table Trasteos");
        db.execSQL(Trasteos);
        db.execSQL("drop table Clientes");
        db.execSQL(Clientes);
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }
}
