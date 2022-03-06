package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


class Fitness : Fragment() {
    private lateinit var listView: ListView
    var list: ArrayList<ItemList> = ArrayList()

    override fun onCreateView(                                  // насчет этого метода вроде везде его используют )) даже в предыдущем уроке
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View =  inflater.inflate(R.layout.fragment_universally, container, false)
        var listView : ListView = view.findViewById(R.id.ListViewUniversal)
        val objectLists = setDataArrayList()
        val adapter = ItemListAdapter( view.context , objectLists)
        listView.adapter = adapter
        return view
    }

    private fun setDataArrayList(): ArrayList<ItemList> {

        list.add(
            ItemList(
                R.drawable.jfcgym,
                "JfcGYM",
                "Спортивный клуб",
                "ул. Кара-Кульская 1/4",
                "Открыто до 23:00",
                "Современный спортивный клуб",
                "Обонимент от 2000 сом",
                "+996 700 700 800",
                "https://go.2gis.com/09psfe"
            )
        )
        list.add(
            ItemList(
                R.drawable.beuty,
                "Beauty dance Studio",
                "Студия фитнеса и танцев",
                "ул. Н. Исанова, 41/1",
                "Открыто до 22:00",
                "Уютное место для \n занятий танцами",
                "обонимент от 2500 сом",
                "+996 552 600 600",
                "https://go.2gis.com/ohmin2"
            )
        )
        list.add(
            ItemList(
                R.drawable.umay,
                "Umai dance fit",
                "Студия фитнеса и танцев",
                "Проспект Манаса 135",
                "Открыто до 17:00",
                "Народныe, современные,\n классические танцы",
                "Средний чек 2000 сом",
                "+996 555 456 789",
                "https://go.2gis.com/rbcmm1"
            )
        )
        list.add(
            ItemList(
                R.drawable.dasmia,
                "Dasmia",
                "Этно-комплекс",
                "ул. И. Ахунбаева 17а",
                "Открыто до 22:00",
                "Спортивный комплекс с басейном",
                "Средний чек 2800 сом",
                "+996 777 825 963",
                "https://go.2gis.com/ry01f"
            )
        )


        return list!!
    }


}
