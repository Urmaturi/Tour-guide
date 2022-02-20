package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
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
import androidx.core.view.isVisible


//lateinit var binding: ActivityMainBinding
class ItemListAdapter(var context: Context, var dataSource: ArrayList<ItemList>) : BaseAdapter() {

    //var viewGroup: ViewGroup =
    // val binding : ActivityMainBinding =    DataBindingUtil.inflate(this, R.layout.item_layout, container: ViewGroup? , false)
   // val binding : ActivityMainBinding =    DataBindingUtil.inflate(this, R.layout.item_layout, container  , false)
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


    @RequiresApi(Build.VERSION_CODES.Q)
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
        var constraintLayut : ConstraintLayout = view.findViewById(R.id.constrItem)
        var workGraph2 : TextView = view.findViewById(R.id.tv_workGraph2)
        var adress2: TextView = view.findViewById(R.id.tvAdress2)
        var imageViewGeo: ImageView = view.findViewById(R.id.imageViewGeo)


        var itemList: ItemList = dataSource.get(position)

        imageView.setImageResource(itemList.imageId!!)
        nameText.text = itemList.nameOfPlace
        typeText.text = itemList.typeOfPlace
        adressText.text = itemList.adressOfPlace
        workGrapText.text = itemList.grafOfWork

        aboutPlace.text = itemList.aboutPlace
        telephonePlace.text = itemList.telephone
        costOfPlace.text = itemList.costOfPlace
        adress2.text = itemList.adressOfPlace



        logoGeo.visibility = View.GONE
        logoTel.visibility = View.GONE
        logoInf.visibility = View.GONE
        aboutPlace.visibility = View.GONE
        telephonePlace.visibility = View.GONE
        costOfPlace.visibility = View.GONE

        adressText.visibility = View.GONE
        workGraph2.visibility = View.GONE




        var buttonImg: ImageView = view.findViewById(R.id.buttonOnImgView)
        var tempBool: Boolean = false









        buttonImg.setOnClickListener {
            if (tempBool == false) {
//                Toast.makeText(
//                    context,
//                    "Pressed ${nameText.text} =: ${nameText.id}",
//                    Toast.LENGTH_SHORT
//                ).show()
                nameText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28F);

                adressText.setTextColor(context.getResources().getColor(R.color.name_color) )
                aboutPlace.visibility = View.VISIBLE
                telephonePlace.visibility = View.VISIBLE
                costOfPlace.visibility = View.VISIBLE
                logoGeo.visibility = View.VISIBLE
                logoTel.visibility = View.VISIBLE
                logoInf.visibility = View.VISIBLE
                adressText.visibility = View.VISIBLE
                adress2.isVisible = false

                nameText.setPadding(0,80,0,24)
                aboutPlace.setPadding(0,60,0,20)
                imageViewGeo.setPadding(0,60,0,20)
                costOfPlace.setPadding(0,0,0,60)



                buttonImg.setImageResource(R.drawable.ic_baseline_expand_less_24)

                tempBool = !tempBool
            } else {
                nameText.setPadding(0,0,0,0)
                aboutPlace.setPadding(0,0,0,0)
                costOfPlace.setPadding(0,0,0,0)
                imageViewGeo.setPadding(0,0,0,0)
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


            adressText.setOnClickListener()
            {
                val context = view.context
                val uri = Uri.parse("${itemList.url}")
                val locationintent = Intent(Intent.ACTION_VIEW, uri)
                 startActivity(context,locationintent,null)

                }





            telephonePlace.setOnClickListener()
            {
                val number = Uri.parse("tel:${telephonePlace.text}")
                val callIntent: Intent = Intent(Intent.ACTION_DIAL,number)
                val context = view.context
                startActivity(context,callIntent,null)


            }





        }


        return view!!
    }





}

