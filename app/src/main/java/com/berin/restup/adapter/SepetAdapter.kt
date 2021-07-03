package com.berin.restup.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.berin.restup.databinding.SepetCardBinding
import com.berin.restup.entity.Urunler
import com.berin.restup.fragment.SepetFragmentDirections
import com.berin.restup.viewmodel.SepetFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class SepetAdapter(var mContext: Context, var urunListesi:List<Urunler>, var viewModel: SepetFragmentViewModel )
    :RecyclerView.Adapter<SepetAdapter.SepetCardTasarimTutucu>(){

    inner class SepetCardTasarimTutucu( sepetCardBinding: SepetCardBinding)
        :RecyclerView.ViewHolder(sepetCardBinding.root){
            var sepetCardTasarim:SepetCardBinding
            init {
                this.sepetCardTasarim = sepetCardBinding
            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetCardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = SepetCardBinding.inflate(layoutInflater,parent,false)
        return SepetCardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: SepetCardTasarimTutucu, position: Int) {
        val urun = urunListesi.get(position)
        holder.sepetCardTasarim.urunNesne = urun
        val image = holder.sepetCardTasarim.imageViewSepetResim
        Picasso.get().load(urun.urun_gorsel_url).into(image)

        holder.sepetCardTasarim.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${urun.urun_adi} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.SurunleriSil(urun.id,0)
                    Snackbar.make(it,"${urun.urun_adi} silindi", Snackbar.LENGTH_SHORT).show()
                }.show()
        }

        holder.sepetCardTasarim.imageViewSepetResim.setOnClickListener {
            val gecis = SepetFragmentDirections.sepetUrunDetayGecis(urun)
            Navigation.findNavController(it).navigate(gecis)
        }
    }
    override fun getItemCount(): Int {
        return urunListesi.size
    }
}