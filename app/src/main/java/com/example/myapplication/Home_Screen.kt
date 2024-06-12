package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Home_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val cardView: androidx.cardview.widget.CardView = findViewById(R.id.card_View)
        val cardView2: androidx.cardview.widget.CardView = findViewById(R.id.card_View2)
        val cardView3: androidx.cardview.widget.CardView = findViewById(R.id.card_View3)
        val cardView4: androidx.cardview.widget.CardView = findViewById(R.id.card_View4)
        val cardView5: androidx.cardview.widget.CardView = findViewById(R.id.card_View5)
        val cardView6: androidx.cardview.widget.CardView = findViewById(R.id.card_View6)

        cardView.setOnClickListener {
            val intent = Intent(this, prdocuts_Screen :: class.java)
            startActivity(intent)
        }
        cardView2.setOnClickListener {
            val intent = Intent(this,Sandwiches :: class.java)
            startActivity(intent)
        }
        cardView3.setOnClickListener {
            val intent = Intent(this,wraps :: class.java)
            startActivity(intent)
        }
        cardView4.setOnClickListener {
            val intent = Intent(this,saladas :: class.java)
            startActivity(intent)
        }
        cardView5.setOnClickListener {
            val intent = Intent(this,deserts :: class.java)
            startActivity(intent)
        }
        cardView6.setOnClickListener {
            val intent = Intent(this,cold_Drinks :: class.java)
            startActivity(intent)
        }

    }
}