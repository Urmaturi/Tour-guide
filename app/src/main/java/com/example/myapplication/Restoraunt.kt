package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


class Restoraunt : Fragment() {

    private lateinit var listView: ListView
    var list: ArrayList<ItemList> = ArrayList()

    override fun onCreateView(                                  // насчет этого метода вроде везде его используют )) даже в предыдущем уроке
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_universally, container, false)
        var listView: ListView = view.findViewById(R.id.ListViewUniversal)
        val objectLists = setDataArrayList()
        val adapter = ItemListAdapter(view.context, objectLists)
        listView.adapter = adapter
        return view
    }

    private fun setDataArrayList(): ArrayList<ItemList> {

        list.add(
            ItemList(
                R.drawable.cyclone,
                "Cyclone",
                "Ресторан",
                "Проспект Чуй 136",
                "Открыто до 05:00",
                "Ресторан европейской кухни",
                "Cредний чек 2000 сом",
                "+996 700 700 800",
                "https://go.2gis.com/4m5c3q"
            )
        )
        list.add(
            ItemList(
                R.drawable.anar,
                "Anar",
                "Ресто-чайхана",
                "ул. Льва Толстого, 102/4",
                "Открыто до 02:00",
                "Восточная кухня",
                "Средний чек 1500 сом",
                "+996 552 600 600",
                "https://go.2gis.com/ezut5g"
            )
        )
        list.add(
            ItemList(
                R.drawable.baikazan,
                "Bai Kazan",
                "Ресто-чайхана",
                "ул. К. Баялинова 131",
                "Открыто до 23:00",
                "Восточная кухня",
                "Средний чек 2000 сом",
                "+996 555 456 789",
                "https://go.2gis.com/q099h"
            )
        )
        list.add(
            ItemList(
                R.drawable.barhat,
                "Barhat",
                "Ресто-чайхана",
                "ул. И. Ахунбаева 17а",
                "Открыто до 24:00",
                "Восточная кухня",
                "Средний чек 1800 сом",
                "+996 777 825 963",
                "https://go.2gis.com/6gba7"
            )
        )


        return list!!
    }


}