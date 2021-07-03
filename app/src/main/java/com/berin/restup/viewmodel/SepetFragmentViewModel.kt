package com.berin.restup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berin.restup.entity.Urunler
import com.berin.restup.repo.UrunlerdaoRepos

class SepetFragmentViewModel :ViewModel() {

    private val udaor = UrunlerdaoRepos()
    var sepetUrunListesi = MutableLiveData<List<Urunler>>()

    init {
        SurunleriAl()
        sepetUrunListesi = udaor.SurunList()
    }

    fun SurunleriAl(){
        udaor.sepettekiUrunleriAl()
    }


    fun SurunleriSil(id:Int,sepet_durum:Int){
        udaor.sepetDurumGuncelle(id,sepet_durum)
    }
}