package com.example.mad_practical10_21012011002

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class PersonAdapter (context: Context, val PersonArray:ArrayList<Person>):ArrayAdapter<Person>(context,0,PersonArray) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.person_item, parent, false)
        view.findViewById<TextView>(R.id.name).text=PersonArray[position].name
        view.findViewById<TextView>(R.id.mobile).text=PersonArray[position].phoneNo
        view.findViewById<TextView>(R.id.emailid).text=PersonArray[position].emailId
        view.findViewById<TextView>(R.id.address).text=PersonArray[position].address
        return view
    }
}