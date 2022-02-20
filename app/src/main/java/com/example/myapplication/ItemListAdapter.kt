package com.example.myapplication

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

//lateinit var binding: ActivityMainBinding
class ItemListAdapter(var context: Context, var dataSource: ArrayList<ItemList>) : BaseAdapter() {


    // val binding : ActivityMainBinding =    DataBindingUtil.inflate(this, R.layout.item_layout, container: ViewGroup? , false)
         //.setContentView( inflater, R.layout.item_layout)




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

        var aboutPlace: TextView = view.findViewById(R.id.tvAbout)
        var telephonePlace: TextView = view.findViewById(R.id.tvTelephone)
        var costOfPlace: TextView = view.findViewById(R.id.tvChek)

        var logoTel: ImageView = view.findViewById(R.id.imageViewPhone)
        var logoGeo: ImageView = view.findViewById(R.id.imageViewGeo)
        var logoInf : ImageView = view.findViewById(R.id.imageViewInfo)

        var itemList: ItemList = dataSource.get(position)

        imageView.setImageResource(itemList.imageId!!)
        nameText.text = itemList.nameOfPlace
        typeText.text = itemList.typeOfPlace
        adressText.text = itemList.adressOfPlace
        workGrapText.text = itemList.grafOfWork

        aboutPlace.text = itemList.aboutPlace
        telephonePlace.text = itemList.telephone
        costOfPlace.text = itemList.costOfPlace



        logoGeo.visibility = View.GONE
        logoTel.visibility = View.GONE
        logoInf.visibility = View.GONE
        aboutPlace.visibility = View.GONE
        telephonePlace.visibility = View.GONE
        costOfPlace.visibility = View.GONE



        var buttonImg: ImageView = view.findViewById(R.id.buttonOnImgView)
        var tempBool: Boolean = false






        buttonImg.setOnClickListener {
            if (tempBool == false) {
//                Toast.makeText(
//                    context,
//                    "Pressed ${nameText.text} =: ${nameText.id}",
//                    Toast.LENGTH_SHORT
//                ).show()
                nameText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30F);
                adressText.setTextColor(context.getResources().getColor(R.color.name_color) )
                aboutPlace.visibility = View.VISIBLE
                telephonePlace.visibility = View.VISIBLE
                costOfPlace.visibility = View.VISIBLE
                logoGeo.visibility = View.VISIBLE
                logoTel.visibility = View.VISIBLE
                logoInf.visibility = View.VISIBLE

                buttonImg.setImageResource(R.drawable.ic_baseline_expand_less_24)

                tempBool = !tempBool
            } else {
                nameText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F);
                aboutPlace.visibility = View.GONE
                telephonePlace.visibility = View.GONE
                costOfPlace.visibility = View.GONE

                logoGeo.visibility = View.GONE
                logoTel.visibility = View.GONE
                logoInf.visibility = View.GONE

                adressText.setTextColor(R.color.black.toInt())
                buttonImg.setImageResource(R.drawable.ic_baseline_expand_more_24)


                tempBool = !tempBool
            }
        }


        return view!!
    }



}

