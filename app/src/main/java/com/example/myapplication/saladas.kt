package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySaladasBinding

class saladas : AppCompatActivity() {

    private lateinit var binding: ActivitySaladasBinding
    private lateinit var productarrayList: ArrayList<products>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaladasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.salad_1,R.drawable.salad_2,R.drawable.salad_3,
            R.drawable.salad_4,R.drawable.salad_5,R.drawable.salad_6,
        )

        val name = arrayOf(
            "Caesar Salad",
            "Greek Salad",
            "Caprese Salad",
            "Cobb Salad",
            "Quinoa Salad",
            "Mediterranean Salad"
        )

        val price = arrayOf(
            "$9", "$8", "$10", "$11", "$7", "$12"
        )

        val description = arrayOf(
            "Crisp romaine lettuce, garlic croutons, parmesan cheese, and Caesar dressing.",
            "Fresh cucumbers, tomatoes, red onions, olives, feta cheese, and Greek dressing.",
            "Sliced tomatoes, fresh mozzarella cheese, basil leaves, balsamic glaze, and olive oil.",
            "Mixed greens, grilled chicken, bacon, avocado, hard-boiled eggs, tomatoes, and blue cheese dressing.",
            "Nutritious quinoa, mixed vegetables, chickpeas, and lemon vinaigrette.",
            "Cherry tomatoes, cucumbers, bell peppers, olives, feta cheese, and lemon herb dressing."
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