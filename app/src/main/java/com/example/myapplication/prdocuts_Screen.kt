package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityHomeScreenBinding
import com.example.myapplication.databinding.ActivityPrdocutsScreenBinding

class prdocuts_Screen : AppCompatActivity() {

    private lateinit var binding: ActivityPrdocutsScreenBinding
    private lateinit var productarrayList: ArrayList<products>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrdocutsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.breakfast1,R.drawable.breakfast2,R.drawable.breakfast3,R.drawable.breakfast4,
            R.drawable.breakfast5,R.drawable.breakfast6,
        )

        val name = arrayOf(
            "Pancakes",
            "Omelette",
            "French Toast",
            "Smoothie Bowl",
            "Avocado Toast",
                "Breakfast Burrito"
        )

        val price = arrayOf(
            "$8", "$7", "$9", "$6", "$10", "$11"
        )

        val description = arrayOf(
            "Fluffy pancakes served with maple syrup and fresh berries.",
            "A classic omelette with cheese, ham, and vegetables.",
            "Golden French toast topped with powdered sugar and fresh fruit.",
            "A refreshing smoothie bowl with mixed berries and granola.",
            "Whole grain toast topped with avocado, cherry tomatoes, and a poached egg.",
            "A hearty burrito filled with eggs, sausage, cheese, and vegetables."
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