package com.aelayyuu.roomdatabase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "book_table")
//    (tableName = "book_table")
class Book  (
    @PrimaryKey

    @ColumnInfo(name = "id")
    var bookID : Int,

    @ColumnInfo(name = "book_name")
    var bookName : String
)     //that's data class can you see?