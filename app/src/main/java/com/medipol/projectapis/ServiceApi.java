package com.medipol.projectapis;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceApi {

    @GET("istanbul/gezilecek_yerler.json")
    Observable<List<Veri>> istanbulGezilecekYerler();

    @GET("burclar/burclar.json")
    Observable<List<Veri>> burclar();

    @GET("hayvanlar/hayvanlar.json")
    Observable<List<Veri>> hayvanlar();

    @POST("api/hocaEkle")
    Observable<List<Veri>> gezilecekYerEkle(@Body Veri veri);

    @PUT("api/hocaGuncelle/{id}")
    Observable<Veri> gezilecekYerGuncelle(@Path("id") String id, @Body Veri guncelVeri);
}
