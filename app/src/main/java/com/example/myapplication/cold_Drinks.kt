package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityColdDrinksBinding

class cold_Drinks : AppCompatActivity() {

    private lateinit var binding: ActivityColdDrinksBinding
    private lateinit var productarrayList: ArrayList<products>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColdDrinksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.breakfast, R.drawable.burger, R.drawable.drink, R.drawable.fish, R.drawable.pizza,
            R.drawable.sandwitch
        )

        val name = arrayOf(
            "Sandwiches",
            "Burger",
            "Drinks",
            "Fish Sand",
            "Pizza",
            "Sandwich",
        )
        val price = arrayOf(
            "100","200","300","400","500","600"
        )
        val description = arrayOf(
            "This is the descrition for Breakfast",
            "This is the descrition for Burger",
            "This is the descrition for Drink",
            "This is the descrition for Fish",
            "This is the descrition for Pizza",
            "This is the descrition for Sandwich",
        )

        productarrayList = ArrayList()

        for (i in name.indices){
            val product = products(name[i], price[i],description[i], imageId[i])
            productarrayList.add(product)
        }

        binding.breakfastList.isClickable = true
        binding.breakfastList.adapter = catagoryAdapter(this,productarrayList)
        binding.breakfastList.setOnItemClickListener { parent, view, position, id ->

//            Here we are pasing the data to the new screen on the click od listItem
            val name = name[position]
            val price = price[position]
            val description = description[position]
            val imageId = imageId[position]

            val i = Intent(this, breakfast_prd_Det :: class.java)
            i.putExtra("name", name)
            i.putExtra("price", price)
            i.putExtra("description", description)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }
    }
}