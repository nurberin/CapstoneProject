package com.berin.restup.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.berin.restup.R
import com.berin.restup.adapter.UrunlerAdapter
import com.berin.restup.databinding.FragmentAnasayfaBinding
import com.berin.restup.viewmodel.AnasayfaFragmentViewModel


class AnasayfaFragment : Fragment(), MenuItem.OnMenuItemClickListener {
    private lateinit var tasarim:FragmentAnasayfaBinding
    private lateinit var adapter: UrunlerAdapter
    private lateinit var viewModel:AnasayfaFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        tasarim.anasayfaFragment = this
        tasarim.toolbarAnasayfa.title = ""

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)//sepet menusunu eklemke için yaptık.
        //viewModel.urunlerYukle()
        viewModel.urunleriAl()
        viewModel.urunListesi.observe(viewLifecycleOwner,{ urunListesi ->
            adapter = UrunlerAdapter(requireContext(),urunListesi,viewModel)
            tasarim.adapter = adapter
        })
        tasarim.rv.layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val temp:AnasayfaFragmentViewModel by viewModels()
        viewModel=temp
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {//burada sepet ikonuna basınca o fragmente geciş sağlamamız lazım.
        inflater.inflate(R.menu.toolbar_sepet,menu)

        //val item = menu. buradaki kodlamalar nasıl olacak hiçbir fikrim yok

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        TODO("Not yet implemented")
    }



}