package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

interface ImplementationOfIntents  {

    fun openMaps(view: View, itemList: ItemList)
    {
        val context = view.context
        val uri = Uri.parse("${itemList.url}")
        val locationintent = Intent(Intent.ACTION_VIEW, uri)
        ContextCompat.startActivity(context, locationintent, null)
    }



}