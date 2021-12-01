package com.example.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickDisplayColor = findViewById<TextView>(R.id.textFour)
        val redColorButton = findViewById<TextView>(R.id.textRed)
        val blueColorButton = findViewById<TextView>(R.id.textBlue)
        val greenColorButton = findViewById<TextView>(R.id.textGreen)

        redColorButton.setOnClickListener{
            clickDisplayColor.setText("Red button clicked")
        }

        blueColorButton.setOnClickListener{
            clickDisplayColor.setText("Blue button clicked")
        }

        greenColorButton.setOnClickListener{
            clickDisplayColor.setText("Green button clicked")
        }
    }
}