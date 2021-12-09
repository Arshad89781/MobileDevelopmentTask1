package com.example.bookfilterwithroom.data

import androidx.room.Embedded
import androidx.room.Relation

data class AuthorWithBooks(
    @Embedded val authorDetails: AuthorDetails,
    @Relation(
        parentColumn = "authorId",
        entityColumn = "authorId"
    )
    val bookDetails: List<BookDetails>
)
