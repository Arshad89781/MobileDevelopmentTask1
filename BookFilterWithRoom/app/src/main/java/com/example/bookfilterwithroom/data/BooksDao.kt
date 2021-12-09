package com.example.bookfilterwithroom.data

import androidx.room.*

@Dao
interface BooksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthor(author:AuthorDetails)//-----

    @Transaction
    @Query("Select authorId from AuthorDetails where authorName=:authorNAme and authorCountry=:country")
    fun isAuthorPresent(authorNAme:String,country:String):Int


    @Transaction
    @Query("Select authorId from AuthorDetails where authorName=:authorNAme")
    suspend fun getIdOfAuthor(authorNAme:String):Int//----

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(vararg book:BookDetails)//----

    @Transaction
    @Query("Select bookId from bookdetails where imageLink=:imageLink and language=:language and link=:link and pages=:pages and title=:title and year=:year")
     fun isBookPresent(imageLink:String,language:String,link :String,pages:Int,title:String,year:Int):Int//---

    @Transaction
    @Query("Select bookId,title from bookdetails where authorId=:authorId")
    suspend fun bookResults(authorId:Int):List<BooksResult>//---
}