package com.aelayyuu.roomexample.repository

import androidx.lifecycle.LiveData
import com.aelayyuu.roomexample.dao.ProductDao
import com.aelayyuu.roomexample.model.Product_Room

class ProductRepository(private val productDao: ProductDao) {

    val allProduct: LiveData<List<Product_Room>> = productDao.getAllProduct()

    suspend fun productInsert(product_Room: Product_Room){
        productDao.insert(product_Room)
    }

    suspend fun productDelete() {
        productDao.deleteAll()
    }

    suspend fun productDeleteItem(id : Int) {
        productDao.deleteItem(id)
    }
}