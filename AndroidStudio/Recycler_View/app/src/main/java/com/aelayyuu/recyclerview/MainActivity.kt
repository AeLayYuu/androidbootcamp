package com.aelayyuu.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aelayyuu.recyclerview.model.Person
import kotlinx.android.synthetic.main.activity_main.*
import mm.com.fairway.fourthapprecyclerview.adapter.PersonAdapter

class MainActivity : AppCompatActivity(), PersonAdapter.ClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var personList = ArrayList<Person>()
        personList.add(Person("John","Android Developer"))
        personList.add(Person("James","Web Developer"))

//        recyclerView.layoutManager =
//            LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)  //test this AYZ
        recyclerView.layoutManager =
            GridLayoutManager(this,2)

        var personAdapter= PersonAdapter(personList)
        recyclerView.adapter = personAdapter
        personAdapter.setOnClickListener(this)
    }

    override fun onClick(person: Person) {
        Toast.makeText(
            this,person.name,
            Toast.LENGTH_LONG)
            .show()
    }
}