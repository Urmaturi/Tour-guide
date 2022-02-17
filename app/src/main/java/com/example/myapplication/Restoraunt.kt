package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.myapplication.databinding.ActivityMainBinding



class Restoraunt : Fragment() {

    private lateinit var listView: ListView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         var view: View =  inflater.inflate(R.layout.fragment_restoraunt, container, false)

        var listView : ListView = view.findViewById(R.id.ListViewRestoraunt)

        val objectLists = setDataArrayList()
        val adapter = ItemListAdapter( view.context , objectLists)
        listView.adapter = adapter


        return view
    }


    private fun setDataArrayList(): ArrayList<ItemList> {
        var list: ArrayList<ItemList> = ArrayList()
        list.add(
            ItemList(
                R.drawable.cyclone,
                "Cyclone",
                "Ресторан",
                "Проспект Чуй 136",
                "Открыто до 05:00",
                "dasf",
                "sdaf"
            )
        )
        list.add(
            ItemList(
                R.drawable.anar,
                "Anar",
                "Ресто-чайхана",
                "ул. Льва Толстого, 102/4",
                "Открыто до 02:00",
                "dasf",
                "sdaf"
            )
        )


        return list!!
    }

}