package com.aelayyuu.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_next.*
import kotlinx.android.synthetic.main.activity_test2.*

class TestActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)


        val count=intent.getStringExtra("Name")
        txttst1.text=count
        val count1=intent.getStringExtra("Age")
        txttst2.text=count1
    }
}