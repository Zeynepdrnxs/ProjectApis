package com.medipol.projectapis;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VeriViewHolder extends RecyclerView.ViewHolder {
    ImageView imgIcon;
    TextView txtBaslik;
    TextView txtAltBaslik;

    public VeriViewHolder(@NonNull View itemView) {
        super(itemView);

        imgIcon = itemView.findViewById(R.id.imgIcon);
        txtBaslik = itemView.findViewById(R.id.txtBaslik);
        txtAltBaslik = itemView.findViewById(R.id.txtAltBaslik);
    }
}


