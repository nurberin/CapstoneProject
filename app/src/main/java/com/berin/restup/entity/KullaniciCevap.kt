package com.berin.restup.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KullaniciCevap (@SerializedName("kullanici")
                         @Expose
                         var kullanicilar:List<Kullanici>,
                           @SerializedName("success")
                         @Expose
                         var success:Int){
}