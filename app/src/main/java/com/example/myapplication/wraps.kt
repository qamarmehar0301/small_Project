package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityWrapsBinding

class wraps : AppCompatActivity() {

    private lateinit var binding: ActivityWrapsBinding
    private lateinit var productarrayList: ArrayList<products>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWrapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.breakfast, R.drawable.burger, R.drawable.drink, R.drawable.fish, R.drawable.pizza,
            R.drawable.sandwitch
        )

        val name = arrayOf(
            "Chicken Caesar Wrap",
            "Vegetable Wrap",
            "Turkey Club Wrap",
            "Buffalo Chicken Wrap",
            "Greek Chicken Wrap",
            "Avocado Ranch Wrap"
        )

        val price = arrayOf(
            "$9", "$8", "$10", "$11", "$7", "$12"
        )

        val description = arrayOf(
            "Grilled chicken, romaine lettuce, parmesan cheese, and Caesar dressing wrapped in a tortilla.",
            "Assorted fresh vegetables, lettuce, and hummus wrapped in a spinach tortilla.",
            "Sliced turkey, bacon, lettuce, tomato, and mayonnaise wrapped in a flour tortilla.",
            "Spicy buffalo chicken, lettuce, tomato, and ranch dressing wrapped in a tortilla.",
            "Grilled chicken, feta cheese, olives, lettuce, tomato, and Greek dressing wrapped in a tortilla.",
            "Avocado, grilled chicken, bacon, lettuce, tomato, and ranch dressing wrapped in a tortilla."
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
