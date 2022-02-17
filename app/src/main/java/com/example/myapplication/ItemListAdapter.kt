package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemListAdapter(var context: Context, var dataSource: ArrayList<ItemList>) : BaseAdapter() {


    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(positions: Int): Any {
        return dataSource[positions]
    }

    override fun getItemId(positionss: Int): Long {
        return positionss.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.item_layout, null)

        var imageView: ImageView = view.findViewById(R.id.imageView)
        var nameText: TextView = view.findViewById(R.id.tv_name_of)
        var typeText: TextView = view.findViewById(R.id.tv_type)
        var adressText: TextView = view.findViewById(R.id.tv_adress)
        var workGrapText: TextView = view.findViewById(R.id.tv_work_graf)

        var itemList: ItemList = dataSource.get(position)

        imageView.setImageResource(itemList.imageId!!)
        nameText.text = itemList.nameOfPlace
        typeText.text = itemList.typeOfPlace
        adressText.text = itemList.adressOfPlace
        workGrapText.text = itemList.grafOfWork

        return view!!
    }

}