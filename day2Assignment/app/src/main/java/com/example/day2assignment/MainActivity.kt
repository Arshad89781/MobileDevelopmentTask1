package com.example.day2assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var clickCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickCountDisplayView = findViewById<TextView>(R.id.clickCountView)
        val clickMeButton = findViewById<TextView>(R.id.clickButton)
        val userNameTextInputView = findViewById<TextInputLayout>(R.id.nameText)

        val numbersMap = mutableMapOf("random" to 0 )

        var value =0



        clickMeButton.setOnClickListener{

            var userName =  userNameTextInputView.editText?.text.toString()
            if(userName.isNullOrEmpty()){
                userName = "random"
            }
            if(!numbersMap.containsKey(userName)){
                numbersMap.put(userName, 1)
            }
            else{

                value = numbersMap[userName]!!
                value++
                numbersMap[userName]=value

            }






             value = numbersMap[userName]!!

            clickCountDisplayView.text = "$userName Clicked $value times"

        }



    }
}


