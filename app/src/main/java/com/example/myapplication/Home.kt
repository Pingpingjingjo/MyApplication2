package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //page transition//
        testBtn.setOnClickListener {
            val intent1 = Intent(this,Test::class.java);
            startActivity(intent1)

        }

        knowledgeBtn.setOnClickListener {
            val intent2 = Intent(this, Knowledge::class.java);
            startActivity(intent2)

        }
        historyBtn.setOnClickListener {
            val intent3 = Intent(this, History::class.java);
            startActivity(intent3)

        }

        }
}
