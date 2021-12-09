package com.example.bookfilterwithroom.data

import androidx.room.ColumnInfo

data class BooksResult(
    @ColumnInfo(name = "bookId") val bookId:Int,
    @ColumnInfo(name = "title") val title:String
)
