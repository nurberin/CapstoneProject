package com.berin.restup.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UrunlerCevap (@SerializedName("urunler")
                         @Expose
                         var urunler:List<Urunler>,
                         @SerializedName("success")
                         @Expose
                         var success:Int){
}