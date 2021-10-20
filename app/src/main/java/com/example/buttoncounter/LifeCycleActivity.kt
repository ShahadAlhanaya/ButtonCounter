package com.example.buttoncounter

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class LifeCycleActivity : AppCompatActivity() {

    lateinit var lastSeenTextView: TextView
//    lateinit var prefs : SharedPreferences

    var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "Activity Lifecycle"


        lastSeenTextView = findViewById(R.id.tv_lastSeen)
//        prefs = getSharedPreferences("com.example.bonuspractice", Context.MODE_PRIVATE)
//        text = prefs.getString("date", "").toString()
    }

    override fun onPause() {
        super.onPause()
        val currentDate = SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(Date())
        text += "\n${currentDate}"
//        saveToSharedPreference("date",text)
        lastSeenTextView.text = text
    }

    override fun onResume() {
        super.onResume()
        text += "\nonline"
//        saveToSharedPreference("date",text)
        lastSeenTextView.text = text
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

//    private fun saveToSharedPreference(key: String, value: String){
//        prefs.edit().putString(key, "").apply()
//    }

}