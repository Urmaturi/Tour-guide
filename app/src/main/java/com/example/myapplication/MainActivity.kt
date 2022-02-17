package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding


    private var arrayList: ArrayList<ItemList>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


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



    override fun onItemClick(parent: AdapterView<*>?, viev: View?, pozition: Int, idiwka: Long) {
         var items: ItemList = arrayList?.get(pozition)!!
        Toast.makeText(applicationContext, "pressed ${items.nameOfPlace}",Toast.LENGTH_SHORT).show()
    }
}