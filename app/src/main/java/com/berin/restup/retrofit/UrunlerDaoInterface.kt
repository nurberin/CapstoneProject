package com.berin.restup.retrofit

import com.berin.restup.entity.CRUDCevap
import com.berin.restup.entity.UrunlerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UrunlerDaoInterface {
    @POST("/urunler.php")
    @FormUrlEncoded
    fun tumUrunler(@Field("satici_adi") satici_adi:String):Call<UrunlerCevap>

    @POST("/urun_ekle.php")
    @FormUrlEncoded
    fun urunEkle(@Field("satici_adi") satici_adi:String,
                 @Field("urun_adi") urun_adi:String,
                 @Field("urun_fiyat") urun_fiyat:String,
                 @Field("urun_aciklama") urun_aciklama:String,
                 @Field("urun_gorsel_url") urun_gorsel_url:String,
                 @Field("sepet_durum") sepet_durum: Int,
                 @Field("urun_indirimli_mi") urun_indirimli_mi: Int):Call<CRUDCevap>

    @POST("/indirimli_urun_durum_degistir.php")
    @FormUrlEncoded
    fun urunIndirimliMi(@Field("id") id:Int,
                        @Field("urun_indirimli_mi") urun_indirimli_mi:Int):Call<CRUDCevap>


    @POST("/sepet_durum_degistir.php")
    @FormUrlEncoded
    fun sepetDurumDegistir(@Field("id") id:Int,
                           @Field("sepet_durum") sepet_durum:Int):Call<CRUDCevap>







}