package com.medipol.projectapis;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        veriGetir();
    }
    //istanbulGezilecekYerler
    //burclarda çağrılabilir istanbulGezilecekYerler
    private void veriGetir() {
        new Service().getServiceApi().hayvanlar().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Veri>>() {
                    List<Veri> veriler = new ArrayList<>();
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(List<Veri> data) {
                        veriler = data;
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete() {
                        if (veriler.size() > 0) {

                            //yukarıdaki veri getir çalışıcak burada da verileri dolduruyor buradaki çağırmayla çalıştı
                            listeDoldur(veriler);
                        }
                    }
                });
    }

    RecyclerView recyclerView;
    private void listeDoldur(List<Veri> veriler)
    {
        recyclerView=findViewById(R.id.rcvVeriler);
        VeriAdapter adapter =new VeriAdapter(veriler,getApplicationContext());
        adapter.setOnItemClickListener(new VeriAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Veri tiklananVeri) {
                Intent detay=new Intent(MainActivity.this,DetayActivity.class);
                detay.putExtra("DETAY", tiklananVeri.getDetay());
                startActivity(detay);

                //Toast.makeText(getApplicationContext(), "Detay : " +tiklananVeri.getDetay(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

}