package com.berin.recyclerviewkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.berin.recyclerviewkullanimi.databinding.FragmentDetaySayfaBinding


class DetaySayfaFragment : Fragment() {

    private lateinit var tasarim:FragmentDetaySayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_detay_sayfa, container, false)

        val bundle:DetaySayfaFragmentArgs by navArgs()
        val gelenNesne = bundle.nesne

        tasarim.kisiNesnesi = gelenNesne

        //tasarim.textViewKisiAd.text = gelenNesne.kisi_ad
        //tasarim.textViewKisiTel.text = gelenNesne.kisi_tel

        return tasarim.root
    }

}