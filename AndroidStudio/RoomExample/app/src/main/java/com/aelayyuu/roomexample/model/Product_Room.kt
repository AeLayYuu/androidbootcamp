package com.aelayyuu.roomexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_Room")
class Product_Room
    (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    var id : Int,
    @ColumnInfo(name = "product_name")
    var name: String,
    @ColumnInfo(name = "product_price")
    var price : Double,
    @ColumnInfo(name = "product_quantity")
    var quantity : Int
)