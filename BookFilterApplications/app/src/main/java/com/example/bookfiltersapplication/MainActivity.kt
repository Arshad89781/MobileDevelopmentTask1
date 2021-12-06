package com.example.bookfiltersapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val count = findViewById<TextView>(R.id.result)
        val resultOne = findViewById<TextView>(R.id.result1)
        val resultTwo = findViewById<TextView>(R.id.result2)
        val resultThree = findViewById<TextView>(R.id.result3)
        val authorInput = findViewById<TextInputLayout>(R.id.AuthorInput)
        val countryInput = findViewById<TextInputLayout>(R.id.CountryInput)

        val titles = mutableListOf<String>()


        button.setOnClickListener{
            titles.clear()

            resultOne.text=""
            resultTwo.text=""
            resultThree.text=""

            val myApplication = application as MyApplication
            val httpApiService = myApplication.httpApiService

            CoroutineScope(Dispatchers.IO).launch {
                val decodedJsonResult = httpApiService.getMyData()

                for (item in decodedJsonResult){
                    if(item.author.lowercase()==authorInput.editText?.text.toString().lowercase() && item.country.lowercase()==countryInput.editText?.text.toString().lowercase()){
                        titles.add(item.title)

                    }

                }


                withContext(Dispatchers.Main){
                    count.text= "result: "+titles.count().toString()
                    if(titles.count()>0)
                        resultOne.text="result: "+titles[0]
                    if(titles.count()>1)
                        resultTwo.text="result: "+titles[1]
                    if(titles.count()>2)
                        resultThree.text="result: "+titles[2]
                }
            }
        }
    }
}