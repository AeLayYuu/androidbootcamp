package com.aelayyuu.roomexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelayyuu.roomexample.adapter.ProductAdapter
import com.aelayyuu.roomexample.model.Product_Room
import com.aelayyuu.roomexample.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_product.*

class MainActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var productAdapter: ProductAdapter
    private val addProductActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productViewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)

        productAdapter = ProductAdapter()

        recyclerviewProduct.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = productAdapter
        }
//        productAdapter.setOnClickListener(this)

        productViewModel.allProduct.observe(this, Observer { product ->
            product.let {
                productAdapter.addProductList(product)
            }
        })

        btnAdd.setOnClickListener {
            val intent = Intent(this, AddProductActivity::class.java)
            Log.d("click",intent.toString())
            startActivityForResult(intent,addProductActivityRequestCode)
        }

        BtnDelete.setOnClickListener {
            productViewModel.delete()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == addProductActivityRequestCode && resultCode == Activity.RESULT_OK) {
            var id = data?.getStringExtra(AddProductActivity.EXTRA_ID)
            var name = data?.getStringExtra(AddProductActivity.EXTRA_NAME)
            var price = data?.getStringExtra(AddProductActivity.EXTRA_PRICE)
            var quantity = data?.getStringExtra(AddProductActivity.EXTRA_QUENTITY)
            var product = Product_Room(id!!.toInt(),name!!,price!!.toDouble(),quantity!!.toInt())
                productViewModel.insert(product)
            }
        }
    }


//    override fun onClick(productRoom: Product_Room) {
//        val builder = AlertDialog.Builder(this)
//        builder.apply { "Delete item" }
////        setMessage("Are you sure to delete ! ")
////        setIcon(android.R.drawable.dialog_frame)
////        setPositiveButtion("Yes") {
//
//        }
//    }
//}