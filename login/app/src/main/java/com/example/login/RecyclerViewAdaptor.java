package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.Serializable;
import java.util.List;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder> {

    
Button btn1;

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comida,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.nombre.setText(comidaLista.get(position).getNombre());
        holder.precio.setText("Precio: "+comidaLista.get(position).getPrecio()+" $");
        holder.descripcion.setText("Descripción: "+comidaLista.get(position).getDescripcion());
        holder.fotoComida.setImageResource(comidaLista.get(position).getImgCantante());
        holder.setOnclickListener();
    }

    @Override
    public int getItemCount() {
        return comidaLista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        Context context;
        private TextView nombre, descripcion,precio;
        ImageView fotoComida;
        Button bnt1;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            descripcion = itemView.findViewById(R.id.tvdescripcion);
            precio=itemView.findViewById(R.id.tvPrecio);
            fotoComida = itemView.findViewById(R.id.imgComida);
            precio=itemView.findViewById(R.id.tvPrecio);
            bnt1=itemView.findViewById(R.id.bntpedir);
            context=itemView.getContext();
        }
        void setOnclickListener() {
            bnt1.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intento=new Intent(context,Pago.class);
            intento.putExtra("nombre",nombre.getText());
            intento.putExtra("precio",precio.getText());
//            intento.putExtra("foto", (Serializable) fotoComida.getDrawable());
            context.startActivity(intento);
        }

    }

    
    public List<comidaModelo> comidaLista;

    public RecyclerViewAdaptor(List<comidaModelo> comidaLista){
        this.comidaLista=comidaLista;
    }


}
