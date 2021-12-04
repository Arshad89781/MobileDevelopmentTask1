package com.example.guessnumberactivity

import android.content.Intent
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
        val newScreenActivity=Intent(this,ResultScreenActivity::class.java)
        var player1 = (0..1000).random().toString()
        var count = 0

        userInput.setOnClickListener{
            count++
            var chances=12-count
            var userGuessValue = inputBox.editText?.text.toString()
            if(count<12){
                if (userGuessValue > player1){
                    userResult.text="No:) My number is smaller ,You havn't yet found the solution \n $chances chances remaining"

                }
                else if(userGuessValue < player1){
                    userResult.text="No:) My number is bigger ,You havn't yet found the solution \n $chances chances remaining"
                }
                else{
                    userResult.text="You are right!"
                    newScreenActivity.putExtra("Value",player1)
                    newScreenActivity.putExtra("status","1")
                    startActivity(newScreenActivity)
                    count=0
                    player1 = (0..1000).random().toString()
                    userResult.text=""

                }

            }
            else{
                newScreenActivity.putExtra("Value",player1)
                newScreenActivity.putExtra("status","0")
                startActivity(newScreenActivity)
                count=0
                player1 = (0..1000).random().toString()
                userResult.text=""
            }


        }
    }

}