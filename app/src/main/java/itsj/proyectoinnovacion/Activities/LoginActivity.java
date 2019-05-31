package itsj.proyectoinnovacion.Activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import itsj.proyectoinnovacion.Common.AppDataBase;
import itsj.proyectoinnovacion.POJOS.Usuarios;
import itsj.proyectoinnovacion.R;

public class LoginActivity extends AppCompatActivity {

    Button login, create;
    EditText user, pass;
    public static String usuarioReferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);

        login = findViewById(R.id.btnLogin);
        create = findViewById(R.id.btnCrearCuenta);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = user.getText().toString();
                usuarioReferencia = usuario;
                String contraseña = pass.getText().toString();

                try {
                    Usuarios userLogin = MainActivity.db.usuariosDAO().findByUsers(usuario);

                    SharedPreferences sp = getSharedPreferences("usuarios", MODE_PRIVATE);
                    final SharedPreferences.Editor editor = sp.edit();
                    editor.putString("usuarios", userLogin.getUser());
                    editor.putString("passwords", userLogin.getPassword());
                    editor.commit();

                    SharedPreferences preferences = getSharedPreferences("usuarios", MODE_PRIVATE);

                    if(usuario.equals(preferences.getString("usuarios", "x"))) {
                        if(contraseña.equals(preferences.getString("passwords", "x"))) {
                            Intent i = new Intent(LoginActivity.this, PantallaPrincipal.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Password wrong", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "User wrong", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e){
                    Toast.makeText(LoginActivity.this, "No existe ese usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentU = new Intent(LoginActivity.this, UsuariosActivity.class);
                startActivity(intentU);
            }
        });

    }
}
