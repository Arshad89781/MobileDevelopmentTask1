package com.example.bookfilterwithroom.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AuthorDetails::class,BookDetails::class],version = 1,exportSchema = false)
abstract class BooksDatabase:RoomDatabase() {
    abstract  fun booksDao():BooksDao
}