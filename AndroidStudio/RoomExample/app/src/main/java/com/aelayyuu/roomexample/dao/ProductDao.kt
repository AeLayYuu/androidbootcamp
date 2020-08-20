package com.aelayyuu.roomexample.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aelayyuu.roomexample.model.Product_Room

@Dao
interface ProductDao {

    @Query(value = "Select * from product_Room ORDER BY product_name ASC")
    fun getAllProduct(): LiveData<List<Product_Room>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(productRoom: Product_Room)

    @Query("Delete from product_Room")
    suspend fun deleteAll()

    @Query("Delete from product_Room WHERE product_id =:id")
    suspend fun deleteItem(id: Int)
}