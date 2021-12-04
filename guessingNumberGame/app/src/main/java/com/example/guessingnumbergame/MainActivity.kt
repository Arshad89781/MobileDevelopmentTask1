package com.example.guessingnumbergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputBox = findViewById<TextInputLayout>(R.id.textInputLayout)
        val userInput = findViewById<TextView>(R.id.buttonClick)
        val userResult = findViewById<TextView>(R.id.resultView)

        var player1 = (0..1000).random().toString()


        userInput.setOnClickListener{
            var userGuessValue = inputBox.editText?.text.toString()
            if (userGuessValue > player1){
                userResult.text="No:) My number is smaller "

            }
            else if(userGuessValue < player1){
                userResult.text="No:) My number is bigger "
            }
            else{
                userResult.text="You are right! and Guess new number"
                player1 = (0..1000).random().toString()
            }
        }


    }
}