package itsj.proyectoinnovacion.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import itsj.proyectoinnovacion.Activities.MainActivity;
import itsj.proyectoinnovacion.Activities.PantallaPrincipal;
import itsj.proyectoinnovacion.Fragments.FragmentBD;
import itsj.proyectoinnovacion.POJOS.Ventas;
import itsj.proyectoinnovacion.R;

public class VentasAdapter extends RecyclerView.Adapter<VentasAdapter.ViewHolder> {

    List<Ventas> ventasList;
    Context context;

    public VentasAdapter(List<Ventas> ventasList, Context context) {
        this.ventasList = ventasList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item, viewGroup, false);
        VentasAdapter.ViewHolder viewHolder = new VentasAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VentasAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.id.setText(String.valueOf(ventasList.get(i).getIdVenta()));
        viewHolder.responsable.setText(String.valueOf(ventasList.get(i).getNombreResponsableVenta()));
        viewHolder.total.setText("Cantidad: $"+String.valueOf(ventasList.get(i).getTotalVenta()));
        viewHolder.fecha.setText("Fecha: "+String.valueOf(ventasList.get(i).getFechaVenta()));

        viewHolder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.db.ventasDAO().deleteVenta(ventasList.get(i));
                Toast.makeText(context, "Se eliminó un elemento", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ventasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView id, responsable, fecha, total;
        Button eliminar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            responsable = itemView.findViewById(R.id.responsable);
            fecha = itemView.findViewById(R.id.fecha);
            total = itemView.findViewById(R.id.cantidad);
            cardView = itemView.findViewById(R.id.cardViewPaginas);
            eliminar = itemView.findViewById(R.id.eliminar);
        }
    }
}

