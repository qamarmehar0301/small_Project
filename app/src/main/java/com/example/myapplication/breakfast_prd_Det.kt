package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.databinding.ActivityBreakfastPrdDetBinding

class breakfast_prd_Det : AppCompatActivity() {

    private lateinit var binding: ActivityBreakfastPrdDetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBreakfastPrdDetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Moving to the new screen
        val buyNowBtn: Button = findViewById(R.id.buyNow_btn)
        buyNowBtn.setOnClickListener {
            val intent = Intent(this,Buy_Now :: class.java)
            startActivity(intent)
        }


        //Getting the data sent by the previous Intent
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val description = intent.getStringExtra("description")
        val imageId = intent.getIntExtra("imageId", R.drawable.breakfast)

        //Mapping it on this intent
        binding.prdDetName.text = name
        binding.prdDetPrice.text = price
        binding.prdDetDes.text = description
        binding.prdDetImg.setImageResource(imageId)

    }
}