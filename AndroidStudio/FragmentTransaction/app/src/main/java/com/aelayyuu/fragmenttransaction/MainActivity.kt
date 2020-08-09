package com.aelayyuu.fragmenttransaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.aelayyuu.fragmenttransaction.fragment.OneFragment
import com.aelayyuu.fragmenttransaction.fragment.ThreeFragment
import com.aelayyuu.fragmenttransaction.fragment.TwoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOne.setOnClickListener{

            val oneFragment = OneFragment()
            val transation = supportFragmentManager.beginTransaction()
            transation.add(R.id.fragmentContainer,oneFragment)
            transation.commit()
        }
        btnTwo.setOnClickListener{

            val twoFragment = TwoFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,twoFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        btnThree.setOnClickListener {

            val threeFragment = ThreeFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer,threeFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}
