package com.berin.recyclerviewkullanimi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.berin.recyclerviewkullanimi.databinding.CardTasarimBinding
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var nContext:Context, var kisilerListesi:List<Kisiler>)
    :RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(cardTasarimBinding: CardTasarimBinding)
        : RecyclerView.ViewHolder(cardTasarimBinding.root){
        var cardTasarim:CardTasarimBinding
        init {
            this.cardTasarim = cardTasarimBinding
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(nContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }
    override fun getItemCount(): Int {
        return kisilerListesi.size
    }//buraya kadarki iki methotta her şey aynı olacak genel işlem alttaki sınıfta yapılack. Rv kullanırken bu iki
    //sınıfı kopyalayablirsim
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)
        // holder.cardTasarim.textViewKisiBilgi.text = "${kisi.kisi_ad} - ${kisi.kisi_tel}"
        holder.cardTasarim.kisiNesnesi = kisi

        holder.cardTasarim.satirCard.setOnClickListener {
            //Toast.makeText(nContext,"${kisi.kisi_ad} seçildi",Toast.LENGTH_SHORT).show()

            val gecis = AnaSayfaFragmentDirections.detayaGecis(kisi)
            Navigation.findNavController(it).navigate(gecis)
            //Navigation.findNavController(it).navigate(R.id.detayaGecis)//it yerine card id yi yazabilirdik. holder.cardTasarim.satirCard şeklinde
        }
        holder.cardTasarim.imageViewMore.setOnClickListener {
            val popup = PopupMenu(nContext,it)  //burada popoup menu nun androidx olanı seçtik
            popup.menuInflater.inflate(R.menu.satir_menu,popup.menu)
            popup.show()

            popup.setOnMenuItemClickListener { item->

                when(item.itemId){
                    R.id.action_sil->{
                            Snackbar.make(it,"${kisi.kisi_ad} silmek istiyor musun?",Snackbar.LENGTH_LONG)
                                    .setAction("Evet"){
                                        //veritabanından silme işlemi burada yapılıyor
                                        Snackbar.make(it,"${kisi.kisi_ad} silindi",Snackbar.LENGTH_LONG).show()
                                    }
                                    .show()
                        true
                    }
                    R.id.action_guncelle->{
                        Snackbar.make(it,"${kisi.kisi_ad} güncellendi",Snackbar.LENGTH_LONG).show()
                        true
                    }
                    else -> false

                }
            }
        }
    }
}