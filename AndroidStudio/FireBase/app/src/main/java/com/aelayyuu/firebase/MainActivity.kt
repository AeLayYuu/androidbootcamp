package com.aelayyuu.firebase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.PhantomReference

class MainActivity : AppCompatActivity() {

    private lateinit var dbReference: DatabaseReference
    private lateinit var firebaseDatabase: FirebaseDatabase

    private var userID : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseDatabase = FirebaseDatabase.getInstance()
        dbReference = firebaseDatabase.getReference("user id")

        userID = dbReference.push().key.toString()

        btnSave.setOnClickListener{

//            createUser(editUserName.text.toString(),editUserPhoneNumber.text.toString())

            if (TextUtils.isEmpty(userID)) {
                createUser("","")
            }else {
                updatUser("","")

            }
        }

    }

    fun createUser(name: String , mobile : String) {
        val user= User(name , mobile)
        dbReference.child(userID).setValue(user)
    }

    fun updatUser (name: String,mobile : String){  // function for data add with edit text
        if(!TextUtils.isEmpty(name)){
            dbReference.child(userID).child("name").setValue(name)
        }
        if (!TextUtils.isEmpty(mobile)){

            dbReference.child(userID).child("mobile").setValue(mobile)

        }

        dbReference.child(userID).addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
//                var user = snapshot.getValue(User::class.java)
                var user = User(name,mobile)

                editUserName.setText(user?.name)
                editUserPhoneNumber.setText(user?.mobile)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

}