package com.example.buttoncounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ButtonCounterActivity : AppCompatActivity() {

    var count = 26
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_counter)

        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "Button Counter Activity"

        val plusButton = findViewById<Button>(R.id.btn_plus)
        val minusButton = findViewById<Button>(R.id.btn_minus)
        val countTextView = findViewById<TextView>(R.id.tv_26)

        countTextView.text = count.toString()

        plusButton.setOnClickListener {
            count++
            countTextView.text = count.toString()
        }

        minusButton.setOnClickListener {
            count--
            countTextView.text = count.toString()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}