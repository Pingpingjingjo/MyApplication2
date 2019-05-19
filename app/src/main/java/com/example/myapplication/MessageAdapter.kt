package com.example.myapplication


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MessageAdapter(val mContext: Context, val layoutResId:Int, val messageList:List<SignUpRecord>): ArrayAdapter<SignUpRecord>(mContext,layoutResId,messageList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mContext)
        val view:View = layoutInflater.inflate(layoutResId,null)
        val msg = messageList[position]
        val msgText = view.findViewById<TextView>(R.id.msgView)
        //msgText.text = msg.message + "  Rating: " + msg.rating.toString()

        return view
    }
}
