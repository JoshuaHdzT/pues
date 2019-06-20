package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdaptor2 extends RecyclerView.Adapter<RecyclerViewAdaptor2.ViewHolder> {
    @NonNull
    @Override
    public RecyclerViewAdaptor2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial,parent,false);
        RecyclerViewAdaptor2.ViewHolder viewHolder1=new RecyclerViewAdaptor2.ViewHolder(view);

        return viewHolder1;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdaptor2.ViewHolder holder, int position) {
        holder.nombre1.setText(comidaLista1.get(position).getNombre());
        holder.precio1.setText("Precio: "+comidaLista1.get(position).getPrecio()+" $");
        holder.descripcion1.setText("Descripción: "+comidaLista1.get(position).getDescripcion());
        holder.fotoComida1.setImageResource(comidaLista1.get(position).getImgCantante());
        holder.setOnclickListener();
    }

    @Override
    public int getItemCount() {
        return comidaLista1.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        private TextView nombre1, descripcion1,precio1;
        ImageView fotoComida1;
        Button bnt1;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre1 = itemView.findViewById(R.id.tvNombre1);
            descripcion1 = itemView.findViewById(R.id.tvDescripcion1);
            precio1=itemView.findViewById(R.id.tvPrecio1);
            fotoComida1 = itemView.findViewById(R.id.imgComida1);
            precio1=itemView.findViewById(R.id.tvPrecio1);
            bnt1=itemView.findViewById(R.id.btnComentar);
            context=itemView.getContext();
        }
        void setOnclickListener(){
            bnt1.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intento=new Intent(context,EvaluarComida.class);
            intento.putExtra("nombre",nombre1.getText());
            context.startActivity(intento);
        }
    }

    public List<comidaModelo> comidaLista1;

    public RecyclerViewAdaptor2(List<comidaModelo> comidaLista1){
        this.comidaLista1=comidaLista1;
    }


}

