package itsj.proyectoinnovacion.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;

import itsj.proyectoinnovacion.Activities.LoginActivity;
import itsj.proyectoinnovacion.Activities.MainActivity;
import itsj.proyectoinnovacion.POJOS.Ventas;
import itsj.proyectoinnovacion.R;

public class FragmentRegistros extends Fragment {

    EditText idVentas, ventas, nombre;
    Spinner spinnerMes, spinnerAño;
    Button añadir;
    //private VentasDAO_NO_FUNCIONAL ventaDAO = new VentasDAO_NO_FUNCIONAL(getActivity());

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        idVentas = view.findViewById(R.id.txtIDVenta);
        ventas = view.findViewById(R.id.txtVentas);
        nombre = view.findViewById(R.id.txtFirma);
        spinnerMes = view.findViewById(R.id.spinnerMes);
        spinnerAño = view.findViewById(R.id.spinnerAño);
        añadir = view.findViewById(R.id.btnAñadir);

        String[] arregloMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        ArrayAdapter adaptador = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, arregloMeses);

        ArrayList arrayListAños = new ArrayList();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 2000; i <= thisYear; i++) {
            arrayListAños.add(i);
        }
        ArrayAdapter adaptador2 = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, arrayListAños);

        spinnerMes.setAdapter(adaptador);
        spinnerAño.setAdapter(adaptador2);

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarVenta(v);
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_registros, container, false);
        return rootView;
    }

    public void agregarVenta(View v) {

        String id = idVentas.getText().toString();
        String total = ventas.getText().toString();
        String fecha = spinnerMes.getSelectedItem().toString()+"/"+spinnerAño.getSelectedItem().toString();
        String responsable = MainActivity.db.usuariosDAO().findByUsers(LoginActivity.usuarioReferencia).getNombre()+" "+MainActivity.db.usuariosDAO().findByUsers(LoginActivity.usuarioReferencia).getApellidoP() ; //nombre.getText().toString();

        Ventas registroVenta = new Ventas(Integer.parseInt(id), Double.parseDouble(total), fecha, responsable);

        if(/*!id.equals("") &&*/ !total.equals("") /*&& !responsable.equals("")*/) {
            MainActivity.db.ventasDAO().insertVenta(registroVenta);
            Toast.makeText(getActivity().getApplicationContext(), "INSERCIÓN CORRECTA", Toast.LENGTH_SHORT).show();
        }  else {
            Toast.makeText(getActivity().getApplicationContext(), "INSERCIÓN INCORRECTA", Toast.LENGTH_SHORT).show();
        }



    }




}
