package itsj.proyectoinnovacion.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import itsj.proyectoinnovacion.Activities.MainActivity;
import itsj.proyectoinnovacion.Adapters.VentasAdapter;
import itsj.proyectoinnovacion.POJOS.Ventas;
import itsj.proyectoinnovacion.R;

public class FragmentBD extends Fragment {

    RecyclerView recyclerView;
    List<Ventas> listaVentas;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewVentas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        listaVentas = MainActivity.db.ventasDAO().getAll();
        //Log.d("MSJ", listaVentas.get(0).getNombreResponsableVenta());
        VentasAdapter adapter = new VentasAdapter(listaVentas, getActivity().getBaseContext());
        recyclerView.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_bd, container, false);
        return rootView;
    }

    public void añadirVenta(List<Ventas> ventas) {
        listaVentas = ventas;
    }


}
