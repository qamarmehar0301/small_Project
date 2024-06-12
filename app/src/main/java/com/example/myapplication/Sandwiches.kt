package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySandwichesBinding

class Sandwiches : AppCompatActivity() {

    private lateinit var binding: ActivitySandwichesBinding
    private lateinit var productarrayList: ArrayList<products>

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySandwichesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.sandwich_1,R.drawable.sandwich_2,R.drawable.sandwich_3,
            R.drawable.sandwich_4,R.drawable.sandwich_5,R.drawable.sandwich_6,
        )

        val name = arrayOf(
            "Club Sandwich",
            "BLT Sandwich",
            "Grilled Cheese Sandwich",
            "Turkey Sandwich",
            "Vegetarian Sandwich",
            "Chicken Salad Sandwich"
        )

        val price = arrayOf(
            "$9", "$8", "$7", "$10", "$6", "$11"
        )

        val description = arrayOf(
            "Triple-decker sandwich with turkey, bacon, lettuce, tomato, and mayonnaise.",
            "Classic sandwich with bacon, lettuce, tomato, and mayonnaise on toasted bread.",
            "Buttery grilled bread with melted cheese in the middle.",
            "Sliced turkey, lettuce, tomato, and mayonnaise on whole grain bread.",
            "Fresh vegetables, cheese, and hummus or avocado spread on whole wheat bread.",
            "Shredded chicken mixed with mayonnaise, celery, and spices, served on bread."
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