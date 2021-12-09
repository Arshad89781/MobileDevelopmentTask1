package com.example.bookfilterwithroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.bookfilterwithroom.data.AuthorDetails
import com.example.bookfilterwithroom.data.BookDetails
import com.example.bookfilterwithroom.data.BooksDatabase
import com.example.bookfilterwithroom.data.BooksResult
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

        val result=  mutableListOf<BooksResult>()
        val titles = mutableListOf<String>()

        val db = Room.databaseBuilder(
            applicationContext,
            BooksDatabase::class.java,"Books_Details",

            ).build()

        val dao =db.booksDao()
        var id:Int=0
        var dataInsrted:Boolean = false

        button.setOnClickListener {

            titles.clear()
            result.clear()

            resultOne.text = ""
            resultTwo.text = ""
            resultThree.text = ""

            val myApplication = application as MyApplication
            val httpApiService = myApplication.httpApiService


            CoroutineScope(Dispatchers.IO).launch {


                val decodedJsonResult = httpApiService.getMyData()

                if(!dataInsrted){
                    for(item in decodedJsonResult){
                        dataInsrted=true
                        if(dao.isAuthorPresent(item.author,item.country)==0){
                            val newAuthor=AuthorDetails(0,item.author,item.country)

                            dao.insertAuthor(newAuthor)
                            id=dao.isAuthorPresent(item.author,item.country)
                            val newBook = BookDetails(0,id ,item.imageLink,item.language,item.link,item.pages,item.title,item.year)
                            dao.insertBook(newBook)
                        }
                        else{
                            if(dao.isBookPresent(item.imageLink,item.language,item.link,item.pages,item.title,item.year)==0){
                                id=dao.isAuthorPresent(item.author,item.country)
                                val newBook = BookDetails(0,id,item.imageLink,item.language,item.link,item.pages,item.title,item.year)
                                dao.insertBook(newBook)

                            }

                        }
                    }

                }
                var authorId:Int=0
                if(authorInput.editText?.text.toString().count()==0 || countryInput.editText?.text.toString().count()==0){
                    authorId=-1
                }
                else{
                    authorId=dao.isAuthorPresent(authorInput.editText?.text.toString(),countryInput.editText?.text.toString())
                }

                if(authorId!=0){
                    for( books in dao.bookResults(authorId)){
                        result.add(books)
                    }
                }

                withContext(Dispatchers.Main) {
                    if(authorId==-1){
                        count.text = "please enter both fields"
                    }
                    else if(authorId==0){
                        count.text = "No records found "

                    }
                    else{
                        count.text = "result: " + result.count().toString()

                    }

                    if (result.count() > 0)
                        resultOne.text = "result: book id: "+result[0].bookId+" ,bookTitle: " + result[0].title
                    if (result.count() > 1)
                        resultTwo.text = "result: book id: "+result[1].bookId+" ,bookTitle: " + result[1].title
                    if (result.count() > 2)
                        resultThree.text = "result: book id: "+result[2].bookId+" ,bookTitle: " + result[2].title
                }
            }
        }




    }
}