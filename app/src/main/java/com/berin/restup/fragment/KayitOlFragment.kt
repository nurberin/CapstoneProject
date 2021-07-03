package com.berin.restup.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.berin.restup.R
import com.berin.restup.databinding.FragmentKayitOlBinding
import com.berin.restup.viewmodel.KullaniciFragmentViewModel

class KayitOlFragment : Fragment() {

    private lateinit var tasarim:FragmentKayitOlBinding
    private lateinit var viewModel:KullaniciFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kayit_ol, container, false)
        tasarim.kayitOlFragment = this

        tasarim.buttonGirisGecis.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.girisEkranınaGecis)
        }
        tasarim.buttonKayit.setOnClickListener {

        }

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarKayitOl)
        //viewModel.kisiEkle()




        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp:KullaniciFragmentViewModel by viewModels()
        viewModel = temp
    }


}