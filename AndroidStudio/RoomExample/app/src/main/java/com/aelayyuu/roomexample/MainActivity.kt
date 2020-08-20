package com.aelayyuu.roomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.AndroidViewModel
import com.aelayyuu.roomexample.adapter.ProductAdapter
import com.aelayyuu.roomexample.model.Product_Room
import com.aelayyuu.roomexample.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity(), ProductAdapter.ClickListener {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var productAdapter: ProductAdapter
    private val addProductActivity = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(productRoom: Product_Room) {
        val builder = AlertDialog.Builder(this)
        builder.apply { "Delete item" }
        setMessage("Are you sure to delete ! ")
        setIcon(android.R.drawable.dialog_frame)
        setPositiveButtion("Yes") {

        }
    }
}