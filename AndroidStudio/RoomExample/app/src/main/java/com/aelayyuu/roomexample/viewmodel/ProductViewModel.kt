package com.aelayyuu.roomexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aelayyuu.roomexample.database.ProductDatabase
import com.aelayyuu.roomexample.model.Product_Room
import com.aelayyuu.roomexample.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ProductRepository
    val allProduct : LiveData<List<Product_Room>>

    init {
        val productDao = ProductDatabase.getDatabase(application).productDao()
        repository = ProductRepository(productDao)
        allProduct = repository.allProduct

    }

    fun insert(productRoom: Product_Room) = viewModelScope.launch {
        repository.productInsert(productRoom)
    }

    fun delete() = viewModelScope.launch {
        repository.productDelete()
    }
    fun deleteItem(id : Int) = viewModelScope.launch {
        repository.productDeleteItem(id)
    }

}