package itsj.proyectoinnovacion.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import itsj.proyectoinnovacion.POJOS.Favoritos;
import itsj.proyectoinnovacion.R;

public class FragmentFavoritos extends Fragment {

    RecyclerView recyclerView;
    List<Favoritos> listaFavoritos;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview_favoritos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        String tit = "Titulo";//getArguments().getString("Titulo");
        String date = "DATE";//getArguments().getString("Fecha");
        String cont = "Contenido";//getArguments().getString("Contenido");
        añadirFavoritos(tit, date, cont);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_favoritos, container, false);
        return rootView;
    }

    public void añadirFavoritos(String titulo, String fecha, String contenido) {
        listaFavoritos = new ArrayList<Favoritos>();
        listaFavoritos.add(new Favoritos(titulo, fecha, contenido));
    }

}
