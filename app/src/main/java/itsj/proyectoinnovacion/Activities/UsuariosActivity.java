package itsj.proyectoinnovacion.Activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import itsj.proyectoinnovacion.Common.AppDataBase;
import itsj.proyectoinnovacion.POJOS.Usuarios;
import itsj.proyectoinnovacion.R;

public class UsuariosActivity extends AppCompatActivity {

    EditText nombre, apellidoP, apellidoM, usuario, contraseña;
    Button crearCuenta;
    //public static final AppDataBase db = Room.databaseBuilder(UsuariosActivity.this, AppDataBase.class, "Usuario").allowMainThreadQueries().build();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        nombre = findViewById(R.id.nombreUsuario);
        apellidoP = findViewById(R.id.apellidoP);
        apellidoM = findViewById(R.id.apellidoM);
        usuario = findViewById(R.id.user);
        contraseña = findViewById(R.id.pass);

        crearCuenta = findViewById(R.id.botonRegistrar);
        crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nombre.getText().toString().equals("") || apellidoP.getText().toString().equals("") || apellidoM.getText().toString().equals("") || usuario.getText().toString().equals("") || contraseña.getText().toString().equals("")) {
                    Toast.makeText(UsuariosActivity.this, "No se pudo crear la cuenta", Toast.LENGTH_SHORT).show();
                } else {
                    //AppDataBase db = Room.databaseBuilder(UsuariosActivity.this, AppDataBase.class, "Usuario").allowMainThreadQueries().build();
                    MainActivity.db.usuariosDAO().insertAll(new Usuarios(nombre.getText().toString(), apellidoP.getText().toString(), apellidoM.getText().toString(), usuario.getText().toString(), contraseña.getText().toString()));
                    Intent intent = new Intent(UsuariosActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(UsuariosActivity.this, "Cuenta creada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}
