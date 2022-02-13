package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.TableLayout
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : FragmentActivity() {
    private lateinit var adapter: NumberAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tableLayout: TabLayout
    val tabNames: Array<String> = arrayOf(
        "Рестораны","Кинотеатры", "Фитнес центры","четвертый"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = NumberAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter
        tableLayout = findViewById(R.id.tableLayout)
        TabLayoutMediator(tableLayout, viewPager) { tab, position ->
            tab.text =  tabNames[position]
        }.attach()
    }
}