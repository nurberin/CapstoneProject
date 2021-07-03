package com.berin.restup.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.berin.restup.entity.CRUDCevap
import com.berin.restup.entity.Urunler
import com.berin.restup.entity.UrunlerCevap
import com.berin.restup.retrofit.ApiUtils
import com.berin.restup.retrofit.UrunlerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UrunlerdaoRepos {

    private val urunlerListesi:MutableLiveData<List<Urunler>>
    private val indirimliUrunListesi:MutableLiveData<List<Urunler>>
    private val sepetUrunListesi:MutableLiveData<List<Urunler>>
    private val udaoi:UrunlerDaoInterface

    init{
        udaoi= ApiUtils.getUrunlerDaoInterface()
        urunlerListesi=MutableLiveData()
        indirimliUrunListesi=MutableLiveData()
        sepetUrunListesi=MutableLiveData()
    }

    fun urunList():MutableLiveData<List<Urunler>> {
        return urunlerListesi
    }

    fun IurunList():MutableLiveData<List<Urunler>>{
        return indirimliUrunListesi
    }

    fun SurunList():MutableLiveData<List<Urunler>>{
        return sepetUrunListesi
    }

    fun tumUrunleriAl() {
        udaoi.tumUrunler("nurberinteker").enqueue(object : Callback<UrunlerCevap> {
            override fun onResponse( call: Call<UrunlerCevap>?, response: Response<UrunlerCevap>) {
                val liste = response.body()!!.urunler
                urunlerListesi.value=liste
            }
            override fun onFailure(call: Call<UrunlerCevap>?, t: Throwable?) {
                println(t?.localizedMessage.toString())
            }
        })
    }

    fun indirimliUrunleriAl(){
        udaoi.tumUrunler("nurberinteker" ).enqueue(object :Callback<UrunlerCevap>{
            override fun onResponse(call: Call<UrunlerCevap>?, response: Response<UrunlerCevap>?) {
                val liste = response?.body()!!.urunler
                val tempList = arrayListOf<Urunler>()
                for(i in liste){
                    if(i.urun_indirimli_mi==1){
                        tempList.add(i)
                    }
                }
                indirimliUrunListesi.value = tempList
                println(tempList)
            }
            override fun onFailure(call: Call<UrunlerCevap>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

    fun sepetDurumGuncelle(id:Int,sepet_durum: Int){
        udaoi.sepetDurumDegistir(id,sepet_durum).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {

                Log.e("Başarılı",response?.body()!!.message)
            }
            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                Log.e("Başarısız",t?.localizedMessage.toString())            }
        })
    }

    fun sepettekiUrunleriAl(){
        udaoi.tumUrunler("nurberinteker").enqueue(object : Callback<UrunlerCevap> {
            override fun onResponse(call: Call<UrunlerCevap>?, response: Response<UrunlerCevap>?) {
                val liste = response?.body()!!.urunler
                val tempList = arrayListOf<Urunler>()
                for(i in liste){
                    if(i.sepet_durum==1){
                        tempList.add(i)
                    }
                }
                sepetUrunListesi.value=tempList            }
            override fun onFailure(call: Call<UrunlerCevap>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

//    fun sepettekiUrunleriSil(){
//        udaoi.tumUrunler("nurberinteker").enqueue(object : Callback<UrunlerCevap> {
//            override fun onResponse(call: Call<UrunlerCevap>?, response: Response<UrunlerCevap>?) {
//                val liste = response?.body()!!.urunler
//                val tempList = arrayListOf<Urunler>()
//                for(i in liste){
//                    if(i.sepet_durum==1){
//                        tempList.remove(i)
//                        udaoi.sepetDurumDegistir(i.id,0)
//                    }
//                }
//                sepetUrunListesi.value=tempList            }
//            override fun onFailure(call: Call<UrunlerCevap>?, t: Throwable?) {
//
//            }
//        })
//    }

    fun urunYukle(satici_adi:String,urun_adi:String,urun_fiyati:String,
                  urun_aciklama:String,urun_gorsel_url:String,sepet_durum:Int,urun_indirimli_mi:Int){
        udaoi.urunEkle(satici_adi,urun_adi,urun_fiyati,urun_aciklama,urun_gorsel_url,sepet_durum,urun_indirimli_mi)
            .enqueue(object:Callback<CRUDCevap>{
                override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                }
                override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
                }

            } )
    }





}