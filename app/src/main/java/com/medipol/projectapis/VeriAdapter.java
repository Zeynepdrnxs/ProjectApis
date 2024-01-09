package com.medipol.projectapis;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VeriAdapter extends RecyclerView.Adapter<VeriViewHolder> {

    List<Veri> veriler;
    Context context;

    public interface OnItemClickListener {
        void onItemClick(Veri tiklananVeri);
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public VeriAdapter(List<Veri> veriler, Context context) {
        this.veriler = veriler;
        this.context = context;
    }


    @NonNull
    @Override
    public VeriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_veri,parent,false);

        VeriViewHolder viewHolder =new  VeriViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(veriler.get(viewHolder.getAdapterPosition()));
            }
        });

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull VeriViewHolder viewHolder, int position) {

        Veri veri=veriler.get(position);
        viewHolder.txtBaslik.setText(veri.getBaslik());
        viewHolder.txtAltBaslik.setText(veri.getAltBaslik());
        GlideUtil.resmiIndiripGoster(context,veri.getResimURL(),viewHolder.imgIcon);
    }

    @Override
    public int getItemCount() {
        return veriler.size();
    }
}