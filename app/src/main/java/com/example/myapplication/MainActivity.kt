package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //page transition
        signinBnt.setOnClickListener {
            val intent1 = Intent(this, Home::class.java);
            startActivity(intent1);
        }
        textView2.setOnClickListener {
            val intent2 = Intent(this, signUp::class.java);
            startActivity(intent2);
        }

        //Connect to database

            //Check username & password exist?

                // username exist but not for password

                // username & password correct






    } //over ride close
} // activity close