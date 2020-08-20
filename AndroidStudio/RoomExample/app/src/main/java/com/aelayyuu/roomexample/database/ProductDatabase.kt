package com.aelayyuu.roomexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aelayyuu.roomexample.dao.ProductDao
import com.aelayyuu.roomexample.model.Product_Room
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities = arrayOf(Product_Room::class),version = 1)
abstract class ProductDatabase : RoomDatabase(){

    abstract fun productDao() : ProductDao

    companion object {
        private var INSTANCE :ProductDatabase?=null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context) : ProductDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ProductDatabase::class.java,
                    "product_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}