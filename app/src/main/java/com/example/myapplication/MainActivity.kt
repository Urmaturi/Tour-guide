package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.TableLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


//    private lateinit var adapter: NumberAdapter
//    private lateinit var viewPager: ViewPager2
//    private lateinit var tableLayout: TabLayout
//    val tabNames: Array<String> = arrayOf(
//        "Рестораны","Кинотеатры", "Фитнес центры","четвертый"
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intial()

        // adapter = NumberAdapter(this)
//        viewPager = findViewById(R.id.pager)
//        viewPager.adapter = adapter
//        tableLayout = findViewById(R.id.tableLayout)
//        TabLayoutMediator(tableLayout, viewPager) { tab, position ->
//            tab.text =  tabNames[position]
//        }.attach()
    }

    private fun intial() {
        binding.viewPager.adapter = PagerAdapter(this)
        binding.tableLayout.tabIconTint = null
        TabLayoutMediator(binding.tableLayout,binding.viewPager)
        {
            tab,pos ->
            when(pos)
            {
                0 -> tab.text = "Рестораны"
                1 -> tab.text = "Фитнес центры"
                2-> tab.text = "Кинотеатры"
            }
        }.attach()





    }
}