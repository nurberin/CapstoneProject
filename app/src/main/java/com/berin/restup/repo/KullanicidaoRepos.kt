package com.berin.restup.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.berin.restup.entity.*
import com.berin.restup.retrofit.ApiUtils
import com.berin.restup.retrofit.KullaniciDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KullanicidaoRepos {

    var kullaniciListesi:MutableLiveData<List<Kullanici>>
    private val kullaniciDeger:MutableLiveData<Int>
    private val kdaoi:KullaniciDaoInterface

    init{
        kdaoi= ApiUtils.getKullaniciDaoInterface()
        kullaniciListesi=MutableLiveData()
        kullaniciDeger= MutableLiveData()
    }

    fun kullaniciDegerAl():MutableLiveData<Int> {
        return kullaniciDeger
    }

    fun kullaniciList():MutableLiveData<List<Kullanici>>{
        return kullaniciListesi
    }

    fun kullaniciGiris(mail:String,sifre:String) {
        kdaoi.girisYap(mail,sifre).enqueue(object : Callback<KullaniciCevap> {
            override fun onResponse( call: Call<KullaniciCevap>?, response: Response<KullaniciCevap>) {
                val liste = response.body()!!.kullanicilar
                kullaniciListesi.value=liste

                val deger = response.body().kullanicilar[0].deger
                kullaniciDeger.value = deger
            }
            override fun onFailure(call: Call<KullaniciCevap>?, t: Throwable?) {
                println(t?.localizedMessage.toString())

            }
        })
    }

    fun kullaniciEkle(mail: String,sifre: String,adSoyad:String,telefon:String){
        kdaoi.kayitOl(mail,sifre,adSoyad,telefon).enqueue(object : Callback<KullaniciCevap> {
            override fun onResponse(call: Call<KullaniciCevap>?, response: Response<KullaniciCevap>) {
                Log.e("Başarı",response.body().success.toString())

            }
            override fun onFailure(call: Call<KullaniciCevap>?, t: Throwable?) {
                println(t?.localizedMessage.toString())
            }
        })
    }





}