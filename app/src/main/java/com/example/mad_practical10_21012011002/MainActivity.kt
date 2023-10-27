package com.example.mad_practical10_21012011002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: FloatingActionButton = findViewById(R.id.btnSwap)
        fab.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val data = HttpRequest().makeServiceCall(
                        "https://api.json-generator.com/templates/qjeKFdjkXCdK/data",
                        "dchj8v1b6qqdjzbqood1jgpachyfzlw58r540gru")
                    withContext(Dispatchers.Main) {
                        try {
                            if(data != null)
                                runOnUiThread{getPersonDetailsFromJson(data)}
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }


            }


        }
    }
    private fun getPersonDetailsFromJson(sJson: String?) {
        val personList = ArrayList<Person>()
        try {
            val jsonArray = JSONArray(sJson)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray[i] as JSONObject
                val person = Person(jsonObject)
                personList.add(person)
            }
            val Personlistviewe=findViewById<ListView>(R.id.listview)
            Personlistviewe.adapter = PersonAdapter(this, personList)
        } catch (ee: JSONException) {
            ee.printStackTrace()
        }
    }


    fun setarraytolistview(){
        val personlistview = findViewById<ListView>(R.id.listview)
        val array = arrayListOf<Person>(
            Person("0484","Chintan","abc@gmail.com","7687547689","mehsana",90.0,90.7),
            Person("11","Sagar","def@gmail.com","6689563456","Rajkot",90.90,909.90),
            Person("15","Dev","hij@gmail.com","5621459455","Junagadh",75.63,45.75),
            Person("29","Bhargav","jkl@gmail.com","1254786532","Veraval",45.21,36.90),
            Person("31","Vivek","xyz@gmail.com","5485659875","Junagadh",45.90,78.21)
        )
        val swap=findViewById<FloatingActionButton>(R.id.btnSwap)
        swap.setOnClickListener{

        }
    }
}