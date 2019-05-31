package itsj.proyectoinnovacion.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;

import itsj.proyectoinnovacion.Fragments.FragmentBD;
import itsj.proyectoinnovacion.Fragments.FragmentNoticias;
import itsj.proyectoinnovacion.Fragments.FragmentGraficas;
import itsj.proyectoinnovacion.Fragments.FragmentFavoritos;
import itsj.proyectoinnovacion.Fragments.FragmentRegistros;
import itsj.proyectoinnovacion.R;

public class PantallaPrincipal extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.naView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if(menuItem.isChecked()){
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }

                drawerLayout.closeDrawers();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(menuItem.getItemId() == R.id.registro) {
                    FragmentRegistros fragment = new FragmentRegistros();
                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.commit();
                } else if(menuItem.getItemId() == R.id.base_de_datos) {
                    FragmentBD fragment = new FragmentBD();
                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.commit();
                }
                /*else if(menuItem.getItemId() == R.id.graficas) {
                    FragmentGraficas fragment = new FragmentGraficas();
                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.commit();
                }*/
                else if(menuItem.getItemId() == R.id.noticias) {
                    FragmentNoticias fragment = new FragmentNoticias();
                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.commit();
                } else if(menuItem.getItemId() == R.id.favoritos) {
                    FragmentFavoritos fragment = new FragmentFavoritos();
                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.commit();
                }

                return false;
            }
        });

        ActionBarDrawerToggle aBDT = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open, R.string.close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(aBDT);
        aBDT.syncState();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentNoticias fragmentP = new FragmentNoticias();
        fragmentTransaction.replace(R.id.fragment, fragmentP);
        fragmentTransaction.commit();
    }

}
