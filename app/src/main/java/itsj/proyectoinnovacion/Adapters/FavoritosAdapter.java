package itsj.proyectoinnovacion.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import itsj.proyectoinnovacion.POJOS.Favoritos;
import itsj.proyectoinnovacion.R;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.ViewHolder> {

    Context context;
    List<Favoritos> listaFavoritos;

    public FavoritosAdapter(Context context, List<Favoritos> listaFavoritos) {
        this.context = context;
        this.listaFavoritos = listaFavoritos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_noticias, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.titulo.setText(String.valueOf(listaFavoritos.get(i).getTitle()));
        viewHolder.fecha.setText(String.valueOf(listaFavoritos.get(i).getPubDate()));
        viewHolder.contenido.setText(String.valueOf(listaFavoritos.get(i).getContent()));
    }

    @Override
    public int getItemCount() {
        return listaFavoritos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titulo, fecha, contenido;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txtTitulo);
            fecha = itemView.findViewById(R.id.txtPubDate);
            contenido = itemView.findViewById(R.id.txtContent);
            cardView = itemView.findViewById(R.id.cardViewPaginas);
        }
    }

}
