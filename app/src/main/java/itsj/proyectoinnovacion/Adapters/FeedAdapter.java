package itsj.proyectoinnovacion.Adapters;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import  android.view.View;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import itsj.proyectoinnovacion.Activities.MainActivity;
import itsj.proyectoinnovacion.Fragments.FragmentFavoritos;
import itsj.proyectoinnovacion.Interface.itemClickListener;
import itsj.proyectoinnovacion.POJOS.Favoritos;
import itsj.proyectoinnovacion.POJOS.RSSObject;
import itsj.proyectoinnovacion.R;

class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public TextView textTitle, textPubDate, textContet;
    public Button btnFav;
    private itemClickListener itemClickListener;

    public FeedViewHolder(View itemView) {
        super(itemView);

        textTitle = itemView.findViewById(R.id.txtTitulo);
        textPubDate = itemView.findViewById(R.id.txtPubDate);
        textContet = itemView.findViewById(R.id.txtContent);
        btnFav = itemView.findViewById(R.id.btnFavoritos);

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

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private RSSObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;

    public FeedAdapter(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       View itemView = inflater.inflate(R.layout.card_noticias, viewGroup, false);
       return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FeedViewHolder feedViewHolder, final int i) {

        feedViewHolder.textTitle.setText(rssObject.getItems().get(i).getTitle());
        feedViewHolder.textPubDate.setText(rssObject.getItems().get(i).getPubDate());
        feedViewHolder.textContet.setText(rssObject.getItems().get(i).getContent());

        feedViewHolder.setItemClickListener(new itemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(!isLongClick){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(rssObject.getItems().get(position).getLink()));
                    browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(browserIntent);
                }
            }
        });

        feedViewHolder.btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = rssObject.getItems().get(i).getTitle();
                String fecha = rssObject.getItems().get(i).getPubDate();
                String contenido = rssObject.getItems().get(i).getContent();
                String link = rssObject.getItems().get(i).getLink();
                MainActivity.db.favoritosDAO().insertFavorito(new Favoritos(titulo, fecha, contenido, link));
                Toast.makeText(mContext, "Añadida a Favoritas", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }
}
