package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_test.*
import android.widget.TextView
import com.google.firebase.database.DatabaseReference



class Test : AppCompatActivity() {
    // for read database
     var value: String = " ";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)



        // read data from database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Test").child("Depression").child("1")

        // val reference = database.reference

        //button5.setOnClickListener {

       // }


        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //dataSnapshot.child()
                value = dataSnapshot.getValue(String::class.java)!!
                testTxt.text = value
                Log.d("TAG", "Value: " + value!!);
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("TAG", "Failed to read value.", error.toException())
            }
        })






    }

}
