package itsj.proyectoinnovacion.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import itsj.proyectoinnovacion.Interface.itemClickListener;
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

        //viewHolder.setItemClickListener(new itemClickListener() {
        //   @Override
        //    public void onClick(View view, int position, boolean isLongClick) {
        //        if(!isLongClick){
        //            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(rssObject.getItems().get(position).getLink()));
        //            browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //            mContext.startActivity(browserIntent);
        //        }
        //    }
        //});

        viewHolder.setItemClickListener(new itemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(!isLongClick) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(listaFavoritos.get(position).getLink()));
                    browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(browserIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaFavoritos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        TextView titulo, fecha, contenido;
        CardView cardView;
        private itemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txtTitulo);
            fecha = itemView.findViewById(R.id.txtPubDate);
            contenido = itemView.findViewById(R.id.txtContent);
            cardView = itemView.findViewById(R.id.cardViewPaginas);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setItemClickListener(itsj.proyectoinnovacion.Interface.itemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }
    }

}
