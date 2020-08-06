package com.aelayyuu.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aelayyuu.viewmodel.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*

class SimpleviewmodelActivity : AppCompatActivity() {
    val shardFile = "SHARED_PREFERENCED"
    var sharedPreferences : SharedPreferences? = null
    var editor : SharedPreferences.Editor? = null
    lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simpleviewmodel)
        countViewModel = ViewModelProvider(this).get(CountViewModel::class.java)
        sharedPreferences=this.getSharedPreferences(shardFile, Context.MODE_PRIVATE)
        editor = sharedPreferences?.edit()
        var storedcount = sharedPreferences?.getInt("COUNT",0)
        txtmain1.text = storedcount.toString()
        btnmain1.setOnClickListener{
           var count = txtmain1.text.toString().toInt()
            countViewModel.setCount(count)
            txtmain1.text=countViewModel.getCount().toString()
        }
    }

    override fun onPause() {
        super.onPause()
        editor?.putInt("COUNT", countViewModel.getCount())
        editor?.apply()
    }
}