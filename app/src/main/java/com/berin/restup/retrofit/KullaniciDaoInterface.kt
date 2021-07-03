package com.berin.restup.retrofit

import com.berin.restup.entity.KullaniciCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface KullaniciDaoInterface {

    @POST("/giris_yap.php")
    @FormUrlEncoded
    fun girisYap(@Field("mail_adres") satici_adi:String,
                 @Field("sifre") sifre:String): Call<KullaniciCevap>

    @POST("uye_ol.php")
    @FormUrlEncoded
    fun kayitOl(@Field("mail_adres") satici_adi:String,
                @Field("sifre") sifre:String,
                @Field("ad_soyad") ad_soyad:String,
                @Field("telefon") telefon:String): Call<KullaniciCevap>
}