package com.example.myapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemListAdapter(var context: Context, var arrayList: ArrayList<ItemList>) : BaseAdapter() {

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.item_layout, null)

        var imageView: ImageView = view.findViewById(R.id.imageView)
        var nameText: TextView = view.findViewById(R.id.tv_name_of)
        var typeText: TextView = view.findViewById(R.id.tv_type)
        var adressText: TextView = view.findViewById(R.id.tv_adress)

        var itemList: ItemList = arrayList.get(position)

        imageView.setImageResource(itemList.imageId!!)
        nameText.text = itemList.nameOfPlace
        typeText.text = itemList.typeOfPlace
        adressText.text = itemList.adressOfPlace




        return view!!
    }

}