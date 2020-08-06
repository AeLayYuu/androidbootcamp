package com.aelayyuu.projectdatab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aelayyuu.projectdatab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var edittext1 : Edittext
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnb1.setOnClickListener{
            edittext1= Edittext(
                binding.txtb1.text.toString(),
                binding.txtb2.text.toString()
            )
            binding.editext=edittext1
        }
    }
}