package com.example.buttoncounter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var onlineTextView: TextView
    lateinit var lastSeenTextView: TextView

    lateinit var prefs : SharedPreferences

    lateinit var currentDate : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        onlineTextView = findViewById(R.id.tv_online)
        lastSeenTextView = findViewById(R.id.tv_lastSeen)
        prefs = getSharedPreferences("com.example.bonuspractice", Context.MODE_PRIVATE)
        currentDate = prefs.getString("date", "").toString()
        lastSeenTextView.text = currentDate

        val buttonCounterButton = findViewById<Button>(R.id.btn_buttonCounter)
        val persistentCalculationButton = findViewById<Button>(R.id.btn_persistentCalculation)
        val arrayListActivityButton = findViewById<Button>(R.id.btn_arrayListActivity)

        buttonCounterButton.setOnClickListener {
            startActivity(Intent(this,ButtonCounterActivity::class.java))
        }
        persistentCalculationButton.setOnClickListener {
            startActivity(Intent(this,PersistentCalculationActivity::class.java))
        }
        arrayListActivityButton.setOnClickListener {
            startActivity(Intent(this,ArrayListActivity::class.java))
        }
    }


    override fun onPause() {
        super.onPause()
        val currentDate = SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(Date())
        saveToSharedPreference("date",currentDate)
        lastSeenTextView.text = currentDate
    }

    override fun onDestroy() {
        super.onDestroy()
        val currentDate = SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(Date())
        saveToSharedPreference("date",currentDate)
        lastSeenTextView.text = currentDate
    }

    fun saveToSharedPreference(key: String, value: String){
        prefs.edit().putString(key, value).apply()
    }

}