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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonCounterButton = findViewById<Button>(R.id.btn_buttonCounter)
        val persistentCalculationButton = findViewById<Button>(R.id.btn_persistentCalculation)
        val arrayListActivityButton = findViewById<Button>(R.id.btn_arrayListActivity)
        val activityLifecycleButton = findViewById<Button>(R.id.btn_ActivityLifecycle)
        val simpleCalculatorButton = findViewById<Button>(R.id.btn_simpleCalculator)
        val imageViewsButton = findViewById<Button>(R.id.btn_imageViews)
        val recyclerViewButton = findViewById<Button>(R.id.btn_recyclerView)

        buttonCounterButton.setOnClickListener {
            startActivity(Intent(this,ButtonCounterActivity::class.java))
        }
        persistentCalculationButton.setOnClickListener {
            startActivity(Intent(this,PersistentCalculationActivity::class.java))
        }
        arrayListActivityButton.setOnClickListener {
            startActivity(Intent(this,ArrayListActivity::class.java))
        }
        activityLifecycleButton.setOnClickListener {
            startActivity(Intent(this,LifeCycleActivity::class.java))
        }
        simpleCalculatorButton.setOnClickListener {
            startActivity(Intent(this,SimpleCalculatorActivity::class.java))
        }
        imageViewsButton.setOnClickListener {
            startActivity(Intent(this,ImageViewsActivity::class.java))
        }
        recyclerViewButton.setOnClickListener {
            startActivity(Intent(this,RecyclerViewActivity::class.java))
        }
    }


}