package com.example.buttoncounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

}