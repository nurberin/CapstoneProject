package com.berin.restup.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berin.restup.databinding.KampanyaCardBinding
import com.berin.restup.entity.Urunler
import com.berin.restup.viewmodel.KampanyaFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class KampanyaAdapter(var mContext: Context, var kampanyaliUrunListesi:List<Urunler>, var viewModel: KampanyaFragmentViewModel)
    :RecyclerView.Adapter<KampanyaAdapter.KampanyaCardTasarimTutucu>() {

    inner class KampanyaCardTasarimTutucu(kampanyaCardBinding: KampanyaCardBinding)
        :RecyclerView.ViewHolder(kampanyaCardBinding.root){
        var kampanyaCardTasarim:KampanyaCardBinding
        init {
            this.kampanyaCardTasarim = kampanyaCardBinding
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KampanyaCardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = KampanyaCardBinding.inflate(layoutInflater,parent,false)
        return KampanyaCardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: KampanyaCardTasarimTutucu, position: Int) {
        val urun = kampanyaliUrunListesi.get(position)
        holder.kampanyaCardTasarim.urunNesne = urun
        val image = holder.kampanyaCardTasarim.imageViewAnasayfa
        Picasso.get().load(urun.urun_gorsel_url).into(image)

        holder.kampanyaCardTasarim.imageViewAnasayfa.setOnClickListener {
            //detaya geçiş yapılacak
        }

        holder.kampanyaCardTasarim.imageViewSepet.setOnClickListener {
            Snackbar.make(it,"${urun.urun_adi} sepete eklensin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.KampanyaSepetiGuncelle(urun.id,1)
                    Snackbar.make(it,"${urun.urun_adi} sepete eklendi", Snackbar.LENGTH_LONG).show()
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return kampanyaliUrunListesi.size
        }
}