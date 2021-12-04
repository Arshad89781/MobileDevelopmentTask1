package com.example.guessnumberactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)

        val message=intent.getStringExtra("status")
        val secrectNumber = intent.getStringExtra("Value")

        if (message=="1" ){
            findViewById<TextView>(R.id.gameResult).text="You Won! The number is"
            findViewById<TextView>(R.id.failTextView).text=""
            findViewById<TextView>(R.id.playerNumber).text=secrectNumber

        }
        else{
            findViewById<TextView>(R.id.gameResult).text="You lost after 12 attempts,\n the number is"
            findViewById<TextView>(R.id.failTextView).text= secrectNumber
            findViewById<TextView>(R.id.playerNumber).text=""

        }


    }
}