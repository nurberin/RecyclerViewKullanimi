package com.berin.recyclerviewkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.berin.recyclerviewkullanimi.databinding.FragmentFilmDetayBinding


class FilmDetayFragment : Fragment() {

    private lateinit var tasarim:FragmentFilmDetayBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_film_detay, container, false)

        val b:FilmDetayFragmentArgs by navArgs()
        val gelenfilm = b.filmNesne
        tasarim.imageViewFilmResim.setImageResource(
                resources.getIdentifier(gelenfilm.film_resim_adi,"drawable",requireContext().packageName))

        tasarim.textViewFilmBaslik.text = gelenfilm.film_adi
        tasarim.textViewYil.text = gelenfilm.film_yil.toString()
        tasarim.textViewKategori.text = gelenfilm.kategori
        tasarim.textViewYonetmen.text = gelenfilm.yonetmen






        return tasarim.root
    }

}