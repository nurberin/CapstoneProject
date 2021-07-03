package com.berin.restup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berin.restup.entity.Urunler
import com.berin.restup.repo.UrunlerdaoRepos

class KampanyaFragmentViewModel :ViewModel() {

    private val udaor = UrunlerdaoRepos()
    var kampanyaliUrunListesi = MutableLiveData<List<Urunler>>()
    init {
        IurunleriAl()
        kampanyaliUrunListesi = udaor.IurunList()
    }

    fun IurunleriAl(){
        udaor.indirimliUrunleriAl( )
    }

    fun KampanyaSepetiGuncelle(id:Int,sepet_durum:Int){
        udaor.sepetDurumGuncelle(id,sepet_durum)
    }


}