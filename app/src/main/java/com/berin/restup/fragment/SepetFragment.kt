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
import com.berin.restup.adapter.SepetAdapter
import com.berin.restup.databinding.FragmentSepetBinding
import com.berin.restup.viewmodel.SepetFragmentViewModel


class SepetFragment : Fragment() {
    private lateinit var tasarim:FragmentSepetBinding
    private lateinit var adapter: SepetAdapter
    private lateinit var viewModel: SepetFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false)
        tasarim.sepetFragment = this

        viewModel.SurunleriAl()


        viewModel.sepetUrunListesi.observe(viewLifecycleOwner,{sepetUrunListesi->
            adapter = SepetAdapter(requireContext(),sepetUrunListesi,viewModel)
            tasarim.adapter = adapter
        })
        tasarim.rv.layoutManager = GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false)


        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val temp:SepetFragmentViewModel by viewModels()
        viewModel=temp
    }

}