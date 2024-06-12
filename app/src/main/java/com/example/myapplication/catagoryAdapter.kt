package com.example.myapplication

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class catagoryAdapter(private val context: Activity, private val arrayList: ArrayList<products>) : ArrayAdapter<products>(context,
    R.layout.breakfast_layout, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        //val view: View = inflater.inflate((R.layout.home_page_item, root: null))
        val view: View = inflater.inflate(R.layout.breakfast_layout, null)

        val imageView: ImageView = view.findViewById(R.id.product_img)
        val name: TextView = view.findViewById(R.id.product_name)
        val price: TextView = view.findViewById(R.id.product_price)
        val description: TextView = view.findViewById(R.id.product_des)

        imageView.setImageResource(arrayList[position].imgId)
        name.text = arrayList[position].name
        price.text = arrayList[position].price
        description.text = arrayList[position].description

        return view
    }
}