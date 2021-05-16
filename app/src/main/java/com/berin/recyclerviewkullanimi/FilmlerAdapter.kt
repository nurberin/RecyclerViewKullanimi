package com.berin.recyclerviewkullanimi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.berin.recyclerviewkullanimi.databinding.FilmCardBinding
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var nContext:Context,var filmlerListesi:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.cardTasarimTutucu>(){

    inner class cardTasarimTutucu(filmCardBinding: FilmCardBinding):RecyclerView.ViewHolder(filmCardBinding.root){

        var tasarim:FilmCardBinding

        init {
            this.tasarim = filmCardBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimTutucu {

        val layoutInflater = LayoutInflater.from(nContext)
        val tasarim = FilmCardBinding.inflate(layoutInflater,parent,false)
        return cardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: cardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position)

        holder.tasarim.imageViewFilm.setImageResource(
                nContext.resources.getIdentifier(film.film_resim_adi,"drawable",nContext.packageName))

        holder.tasarim.textViewFilmAdi.text = film.film_adi
        holder.tasarim.textViewFiyat.text = "${film.film_fiyat} \u20BA"

        holder.tasarim.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${film.film_adi} sepete eklendi.",Snackbar.LENGTH_SHORT).show()
        }

        holder.tasarim.filmCardview.setOnClickListener {
            val gecis = FilmAnasayfaFragmentDirections.filmDetayGecis(film)
            Navigation.findNavController(it).navigate(gecis)

        }
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }


}