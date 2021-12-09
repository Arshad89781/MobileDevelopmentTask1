package com.example.bookfilterwithroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AuthorDetails(
    @PrimaryKey(autoGenerate = true) val authorId:Int,
    val authorName:String,
    val authorCountry:String?
)
