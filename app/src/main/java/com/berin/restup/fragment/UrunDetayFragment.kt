package com.berin.restup.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.berin.restup.R
import com.berin.restup.databinding.FragmentUrunDetayBinding
import com.berin.restup.viewmodel.UrunDetayFragmentViewModel
import com.squareup.picasso.Picasso


class UrunDetayFragment : Fragment() {
    private lateinit var tasarim : FragmentUrunDetayBinding
    private lateinit var viewModel : UrunDetayFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_urun_detay, container, false)
        tasarim.urunDetayFragment = this

        val bundle: UrunDetayFragmentArgs by navArgs()
        val gelenNesne = bundle.urunNesne
        tasarim.urunNesnesi = gelenNesne

        val image = tasarim.imageViewUrunDetay
        Picasso.get().load(gelenNesne.urun_gorsel_url).into(image)


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}