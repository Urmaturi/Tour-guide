package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private var listView: ListView? = null
    private var itemListAdapter: ItemListAdapter? = null
    private var arrayList: ArrayList<ItemList>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listView = findViewById(R.id.ListViewCinema)
        arrayList = ArrayList()
        arrayList = setDataArrayList()
        itemListAdapter = ItemListAdapter(applicationContext, arrayList!!)
        listView?.adapter = itemListAdapter


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intial()


    }

    private fun intial() {
        binding.viewPager.adapter = PagerAdapter(this)
        binding.tableLayout.tabIconTint = null
        TabLayoutMediator(binding.tableLayout, binding.viewPager)
        { tab, pos ->
            when (pos) {
                0 -> tab.text = "Рестораны"
                1 -> tab.text = "Фитнес центры"
                2 -> tab.text = "Кинотеатры"
            }
        }.attach()


    }

    private fun setDataArrayList(): ArrayList<ItemList> {
        var List: ArrayList<ItemList> = ArrayList()
        List.add(
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
        List.add(
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


        return List!!
    }

    override fun onItemClick(parent: AdapterView<*>?, viev: View?, pozition: Int, idiwka: Long) {
         var items: ItemList = arrayList?.get(pozition)!!
        Toast.makeText(applicationContext, "pressed ${items.nameOfPlace}",Toast.LENGTH_SHORT).show()
    }
}