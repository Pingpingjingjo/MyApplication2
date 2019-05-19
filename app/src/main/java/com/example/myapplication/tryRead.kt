package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_try_read.*
import com.google.firebase.database.DatabaseReference



class tryRead : AppCompatActivity() {

    var value: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_try_read)

        /*
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Test").child("Depression").child("1")

        // Write a message to the database
        sendBtn.setOnClickListener(){
            myRef.setValue(sendTxt.text.toString());
       // }

        // Read from the database
       readBtn.setOnClickListener(){
            readTxt.text = value;
       // }

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot.child()
                value = dataSnapshot.getValue(String::class.java)!!
                Log.d("TAG", "Value: " + value!!);
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("TAG", "Failed to read value.", error.toException())
            }
        })
        */
        val reference = FirebaseDatabase.getInstance().reference
        val query = reference.child("Profile").orderByChild("name").equalTo("name")

            query.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0

                    for (issue in dataSnapshot.children) {
                        // do something with the individual "issues"

                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })



    }
}
