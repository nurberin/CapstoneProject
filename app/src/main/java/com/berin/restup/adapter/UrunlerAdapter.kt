package com.berin.restup.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.berin.restup.databinding.AnasayfaCardBinding
import com.berin.restup.entity.Urunler
import com.berin.restup.fragment.AnasayfaFragmentDirections
import com.berin.restup.viewmodel.AnasayfaFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class UrunlerAdapter (var mContext: Context, var urunListesi:List<Urunler>, var viewModel: AnasayfaFragmentViewModel)
    : RecyclerView.Adapter<UrunlerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(anasayfaCardBinding: AnasayfaCardBinding)
        : RecyclerView.ViewHolder(anasayfaCardBinding.root){
        var anasayfaCard: AnasayfaCardBinding
        init {
            this.anasayfaCard = anasayfaCardBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = AnasayfaCardBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = urunListesi.get(position)
        holder.anasayfaCard.urunNesne = urun
        val image = holder.anasayfaCard.imageViewAnasayfa
        Picasso.get().load(urun.urun_gorsel_url).into(image)


        holder.anasayfaCard.imageViewInfo.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.anasayfaUrunDetayGecis(urun)
            Navigation.findNavController(it).navigate(gecis)
        }

        holder.anasayfaCard.imageViewAnasayfa.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.anasayfaUrunDetayGecis(urun)
            Navigation.findNavController(it).navigate(gecis)
        }


        holder.anasayfaCard.imageViewSepet.setOnClickListener {
            Snackbar.make(it,"${urun.urun_adi} sepete eklensin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.AnasayfaSepetiGuncelle(urun.id,1)

                    Snackbar.make(it,"${urun.urun_adi} sepete eklendi",Snackbar.LENGTH_LONG).show()
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return urunListesi.size
    }

}