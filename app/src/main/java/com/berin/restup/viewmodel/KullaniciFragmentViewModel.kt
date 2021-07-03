package com.berin.restup.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berin.restup.entity.Kullanici
import com.berin.restup.repo.KullanicidaoRepos

class KullaniciFragmentViewModel : ViewModel() {

    private val kdaor = KullanicidaoRepos()
    var kullanicilar = MutableLiveData<List<Kullanici>>()

    init {
        girisYap()
        kullanicilar = kdaor.kullaniciListesi
    }

    fun girisYap(){
        //kdaor.kullaniciGiris()
    }

//    fun kisiEkle (){
//        val mailListe = arrayListOf<String>("nur@berin.com")
//        val sifreListe = arrayListOf<String>("123")
//        val adSoyadListe = arrayListOf<String>("Nur Berin")
//        val telListe = arrayListOf<String>("05552224466")
//
//        for( i in 0 until mailListe.size){
//            kdaor.kullaniciEkle(mailListe[i],sifreListe[i],adSoyadListe[i],telListe[i])
//        }
    //}
}