package com.berin.restup.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.berin.restup.R
import com.berin.restup.databinding.FragmentGirisYapBinding

class GirisYapFragment : Fragment() {

    private lateinit var tasarim:FragmentGirisYapBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_giris_yap, container, false)


        tasarim.buttonGiris.setOnClickListener {
            //eğer giriş yapmak için girdiler doğruysa anasayfa ekranına geçiş yapacak
            //Navigation.findNavController(it).navigate(R.id.kayitEkranınaGecis)
        }

        return tasarim.root
    }

    fun kayitButtonTikla (view: View){
        //fab buton kısmını burda yap
        tasarim.buttonKayitGecis.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kayitEkranınaGecis)
        }
        Log.e("Deneme","buton")

    }

}