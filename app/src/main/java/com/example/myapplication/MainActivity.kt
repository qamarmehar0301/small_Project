package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.example.myapplication.databinding.ActivityHomeScreenBinding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton: Button = findViewById(R.id.login_btn)
        //val cardView: Button  = findViewById(R.id.card_View)
        loginButton.setOnClickListener{
            val intent = Intent(this, Home_Screen::class.java)
            startActivity(intent)
        }

    }
}
