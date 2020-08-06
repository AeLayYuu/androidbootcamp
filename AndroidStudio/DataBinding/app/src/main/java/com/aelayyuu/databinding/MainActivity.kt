package com.aelayyuu.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aelayyuu.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var person = Person("Mg Mg","Developer")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.person = person
    }
}