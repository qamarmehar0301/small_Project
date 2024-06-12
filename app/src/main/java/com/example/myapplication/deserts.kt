package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityDesertsBinding

class deserts : AppCompatActivity() {

    private lateinit var binding: ActivityDesertsBinding
    private lateinit var productarrayList: ArrayList<products>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDesertsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.desert1, R.drawable.desert2, R.drawable.desert3,R.drawable.desert4,
            R.drawable.desert5,R.drawable.desert6,
        )

        val name = arrayOf(
            "Cheesecake",
            "Brownie",
            "Tiramisu",
            "Panna Cotta",
            "Lemon Tart",
            "Macarons"
        )

        val price = arrayOf(
            "$5", "$4", "$6", "$5", "$4", "$7"
        )

        val description = arrayOf(
            "A rich and creamy cheesecake with a buttery crust.",
            "A fudgy chocolate brownie with a crispy top.",
            "A classic Italian dessert with layers of coffee-soaked ladyfingers and mascarpone cream.",
            "A creamy vanilla dessert topped with a sweet berry sauce.",
            "A tangy lemon tart with a buttery crust.",
            "Colorful and delicate French macarons with a sweet filling."
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