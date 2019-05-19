package com.example.myapplication

import android.content.Intent
import android.nfc.Tag
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_sign_up.*


class signUp : AppCompatActivity() {

    lateinit var dataReference: DatabaseReference
    lateinit var msgList: MutableList<SignUpRecord>

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_sign_up)
        super.onCreate(savedInstanceState)


        acceptBtn.setOnClickListener() {
            /*  Click BTn then check
            If Uservalid && Password is true
            Then call save()
            IF Uservalid is true && Password is false
            then call toast
            IF uservalid is false && Password is true
            then call toast
            else call both toast

             */


        }//end acceptBtn


    }//end OnCreate

    private fun Password(){
        var a = passtxt1.toString()
        var b = passTxt2.toString()
        if (a == b) {
            return
        } else {
            /*val myToast = Toast.makeText(applicationContext,"Unmatched Password",Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.LEFT,200,200)
            myToast.show()
            */
            Toast.makeText(applicationContext, "Unmatched Password", Toast.LENGTH_SHORT).show()
        }
    }

    private fun Uservalid(){
        msgList = mutableListOf()
        dataReference = FirebaseDatabase.getInstance().getReference("Profile")

        dataReference.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }
            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists()){
                    msgList.clear()
                    for(i in p0.children){
                        val SignUpRecord = i.getValue(SignUpRecord::class.java)
                        msgList.add(SignUpRecord!!)
                    }
                    val adapter = MessageAdapter(applicationContext,R.layout.messages,msgList)
                    //listView.adapter = adapter
                }
            }
        })


    }
    private fun Save(){
        // Save a message to the database
        var database = FirebaseDatabase.getInstance()
        var myRef = database.getReference("Profile")
        var id = 0

        var tempRef = myRef.push()
        val users = SignUpRecord(id.toString(), nameTxt.text.toString(), AgeTxt.text.toString(), passtxt1.text.toString())
        tempRef.setValue(users)

    }

    private fun PageChange(){
        //page transition
        val intent1 = Intent(this, Home::class.java)
        startActivity(intent1)
    }


    /*  poll data from fierbase
        *   save all data into array list
        *   check whether it exist? */
    

}//End program
