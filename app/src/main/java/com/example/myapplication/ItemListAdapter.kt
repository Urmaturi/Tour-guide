package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ItemLayoutBinding
// создал обьеденил в группу вьюшки и убрал лишние визабилити,
// но databinding почему-то не работает посмотрите пожалуйста может быть я сделал чтото не так?
// код сократился в двое но хотелось бы втрое
//  в низу закоментировал)
class ItemListAdapter(var context: Context, var dataSource: ArrayList<ItemList>) : BaseAdapter(),ImplementationOfIntents   {

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

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View = View.inflate(context, R.layout.item_layout, null)

        var binding: ItemLayoutBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_layout, parent, false)

        val imageView: ImageView = view.findViewById(R.id.imageView)
        val nameText: TextView = view.findViewById(R.id.tv_name_of)
        val typeText: TextView = view.findViewById(R.id.tv_type)
        val adressText: TextView = view.findViewById(R.id.tv_adress)
        val workGrapText: TextView = view.findViewById(R.id.tv_work_graf)
        val aboutPlace: TextView = view.findViewById(R.id.tvAbout)
        val telephonePlace: TextView = view.findViewById(R.id.tvTelephone)
        val costOfPlace: TextView = view.findViewById(R.id.tvChek)
        val adress2: TextView = view.findViewById(R.id.tvAdress2)
        var buttonOnImgView: ImageView = view.findViewById(R.id.buttonOnImgView)

        val itemList: ItemList = dataSource.get(position)

        val viewGroup: ConstraintLayout = view.findViewById(R.id.view_group)
        viewGroup.visibility = View.GONE

        imageView.setImageResource(itemList.imageId!!)
        nameText.text = itemList.nameOfPlace
        typeText.text = itemList.typeOfPlace
        adressText.text = itemList.adressOfPlace
        adress2.text = itemList.adressOfPlace
        workGrapText.text = itemList.grafOfWork
        aboutPlace.text = itemList.aboutPlace
        telephonePlace.text = itemList.telephone
        costOfPlace.text = itemList.costOfPlace


   //     binding.tvAdress2.text = itemList.adressOfPlace
//        binding.name = itemList.nameOfPlace
//        binding.tvNameOf.text = itemList.nameOfPlace
//        binding.tvType.text = itemList.typeOfPlace
//        binding.tvAdress.text = itemList.adressOfPlace
//        binding.tvWorkGraf.text = itemList.grafOfWork
//        binding.tvAbout.text = itemList.aboutPlace
//        binding.tvTelephone.text = itemList.telephone
//        binding.tvChek.text = itemList.costOfPlace
//        binding.tvAdress2.text = itemList.adressOfPlace

        var tempBool: Boolean = false

        buttonOnImgView.setOnClickListener {

            if (tempBool == false) {
                nameText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28F);
                adressText.setTextColor(context.getResources().getColor(R.color.name_color))
                buttonOnImgView.setImageResource(R.drawable.ic_baseline_expand_less_24)
                tempBool = !tempBool
                viewGroup.visibility = View.VISIBLE
                workGrapText.visibility = View.GONE
                adress2.visibility = View.GONE
            } else {
                nameText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20F);
                adressText.setTextColor(R.color.black.toInt())
                buttonOnImgView.setImageResource(R.drawable.ic_baseline_expand_more_24)
                viewGroup.visibility = View.GONE
                workGrapText.visibility = View.VISIBLE
                adress2.visibility = View.VISIBLE
                tempBool = !tempBool
            }
        }
        adressText.setOnClickListener {
            val context = view.context
            val uri = Uri.parse("${itemList.url}")
            val locationintent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(context, locationintent, null)
        }

        telephonePlace.setOnClickListener {
            val context = view.context
            val number = Uri.parse("tel:${binding.tvTelephone.text}")
            val callIntent: Intent = Intent(Intent.ACTION_DIAL, number)
            startActivity(context, callIntent, null)
        }

          return view!!
    }


}

