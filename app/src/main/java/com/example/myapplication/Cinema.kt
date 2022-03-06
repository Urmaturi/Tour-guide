package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


class Cinema : Fragment() {

    private lateinit var listView: ListView
    var list: ArrayList<ItemList> = ArrayList()

    override fun onCreateView(     // насчет этого метода вроде везде его используют )) даже в предыдущем уроке
        inflater: LayoutInflater,  // так сделано(architecture UI)  и в ссылках к этому уроку тоже сделано так пожтому не трогал
        container: ViewGroup?,
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
                R.drawable.broadwey,
                "Broadway",
                "кинотеатр",
                "Asia moll 3 этаж",
                "Открыто до 24:00",
                "Самый удобный кинотеатр",
                " от 350 сом",
                "+996 700 700 800",
                "https://go.2gis.com/89va4f"
            )
        )
        list.add(
            ItemList(
                R.drawable.manas,
                "Manas",
                "Кинотеатр",
                "проспект Манаса 47а",
                "Открыто до 23:50",
                "Один из самых больших",
                " от 180 сом",
                "+996 552 600 600",
                "https://go.2gis.com/zy0bi"
            )
        )
        list.add(
            ItemList(
                R.drawable.alatoo,
                "Umai dance fit",
                "Кинотеатр",
                "Проспект Чуй 47а",
                "Открыто до 23:50",
                "один из первых кинотеатров",
                "от 180 сом",
                "+996 555 456 789",
                "https://go.2gis.com/zy0bi"
            )
        )
        list.add(
            ItemList(
                R.drawable.tsum,
                "Цум кинотеарт",
                "Кинотеатр",
                "ул. Шопокова 91",
                "Открыто до 24:00",
                "новый удобный кинотеатр",
                "от 500 сом",
                "+996 777 825 963",
                "https://go.2gis.com/n8cwn"
            )
        )

        return list!!
    }


}