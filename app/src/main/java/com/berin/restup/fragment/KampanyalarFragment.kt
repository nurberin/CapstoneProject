package com.berin.restup.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.berin.restup.R
import com.berin.restup.adapter.KampanyaAdapter
import com.berin.restup.databinding.FragmentKampanyalarBinding
import com.berin.restup.viewmodel.KampanyaFragmentViewModel


class KampanyalarFragment : Fragment() {

    private lateinit var tasarim:FragmentKampanyalarBinding
    private lateinit var adapter: KampanyaAdapter
    private lateinit var viewModel: KampanyaFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kampanyalar, container, false)
        tasarim.kampanyalarFragment = this

        viewModel.IurunleriAl()

        viewModel.kampanyaliUrunListesi.observe(viewLifecycleOwner,{ kampanyaliUrunListesi ->
            adapter = KampanyaAdapter(requireContext(),kampanyaliUrunListesi,viewModel)
            tasarim.adapter = adapter
            //println(kampanyaliUrunListesi)
        })
        tasarim.rv.layoutManager = GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false)


        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val temp:KampanyaFragmentViewModel by viewModels()
        viewModel=temp
    }


}