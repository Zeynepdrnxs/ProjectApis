package com.medipol.projectapis;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetayActivity extends AppCompatActivity {
    TextView txtDetay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        //Ödev kısmı
        txtDetay=findViewById(R.id.textViewDetay);

        String tasinanDetay=getIntent().getStringExtra("DETAY");

        txtDetay.setText(tasinanDetay);
    }


//projemdeki detay sayfasında textview yerine webview kullanarak putExtra ile taşıdığım url i basıyorum

        /* WebView webDetay;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detay);

            webDetay=findViewById(R.id.webDetay);
            String tasinanDetayURL = getIntent().getStringExtra("DETAY");
            webDetay.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
            webDetay.loadUrl(tasinanDetayURL);
        }*/
}

