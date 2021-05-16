package com.berin.recyclerviewkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.berin.recyclerviewkullanimi.databinding.FragmentAnaSayfaBinding


class AnaSayfaFragment : Fragment() {
    private lateinit var tasarim:FragmentAnaSayfaBinding

    private lateinit var adapter: KisilerAdapter
    private lateinit var kisilerListesi:ArrayList<Kisiler>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim =DataBindingUtil.inflate(inflater,R.layout.fragment_ana_sayfa, container, false)

        //rv görünümünü belirliyor.
        //tasarim.rv.layoutManager = LinearLayoutManager(requireContext())//listemiz nasıl görünsün istiyosak onu belirliyoruz.

        //tasarim.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL) //aşağı doğru hareket ediyor.
        // burada 2 sütun sayısını temsil ediyOR VERTİCALDE, horizontalde ise satır sayısını temsil ediyor


        kisilerListesi = ArrayList()
        val k1 = Kisiler(1,"Ahmet","9999999")
        val k2 = Kisiler(2,"Mehmet","777777")
        val k3 = Kisiler(1,"Zeynep","3333333")
        val k4 = Kisiler(1,"Berin","6666666")

        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k4)


        adapter = KisilerAdapter(requireContext(),kisilerListesi)

        //tasarim.rv.adapter = adapter
        tasarim.kisilerAdapter = adapter



        return tasarim.root
    }
}