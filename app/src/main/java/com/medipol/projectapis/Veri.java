package com.medipol.projectapis;
import com.google.gson.annotations.SerializedName;

public class Veri {

/*{
    "ad": "Kartal",
        "resimURL": "https://rawcdn.githack.com/Zeynepdrnxs/ProjectApis-main/51a53e9f796251561592eb5767556282c78670a8/hayvanlar/kartal.png",
        "detay": "-main/51a53e9f796251561592eb5767556282c78670a8/hayvanlar/html/kartal.html",
        "ozellikler": ["Uçucu", "Keskin Bakışlı", "Yüksekten Uçucu"]
},*/
@SerializedName("baslik")
private String baslik;
    @SerializedName("altBaslik")
    private String altBaslik;
    @SerializedName("detay")
    private String detay;
    @SerializedName("resimURL")
    private String resimURL;

    public Veri() {
    }

    public String getBaslik() {
        return baslik;
    }
    public String getAltBaslik() {
        return altBaslik;
    }
    public String getDetay() {
        return detay;
    }
    public String getResimURL() {
        return resimURL;
    }

}

