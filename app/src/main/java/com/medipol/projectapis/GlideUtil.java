package com.medipol.projectapis;

import android.content.Context;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
public class GlideUtil {
    public  static void resmiIndiripGoster(Context context,
                                           String url,
                                           ImageView imageView)
    {
        //farklı boyutlar için
        Glide.with(context)
                .load(url)
                .centerCrop() //resmi sığdırdı
                .into(imageView);
    }
}

