package com.example.bookfilterwithroom.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(ForeignKey(entity = AuthorDetails::class,
    parentColumns = arrayOf("authorId"),
    childColumns = arrayOf("authorId"),onDelete = ForeignKey.CASCADE)))
data class BookDetails(
    @PrimaryKey(autoGenerate = true) val bookId:Int,
    val authorId:Int,
    val imageLink:String,
    val language:String,
    val link :String,
    val pages:Int,
    val title:String,
    val year:Int
)
