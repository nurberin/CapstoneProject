package com.berin.restup.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.berin.restup.R
import com.berin.restup.databinding.FragmentKullaniciDetayBinding
import com.berin.restup.viewmodel.KullaniciDetayFragmentViewModel

class KullaniciDetayFragment : Fragment() {

    private lateinit var tasarim:FragmentKullaniciDetayBinding
    private lateinit var viewModel: KullaniciDetayFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kullanici_detay,container,false)
        tasarim.kullaniciDetayFragment = this



        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: KullaniciDetayFragmentViewModel by viewModels()
        viewModel = temp
    }



}