package com.example.buttoncounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class PersistentCalculationActivity : AppCompatActivity() {

    var double = 0.0
    var float = 0f
    var result = 0.0

    lateinit var doubleEditText : EditText
    lateinit var floatEditText : EditText
    lateinit var resultTextView : TextView
    lateinit var multiplyButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persistent_calculation)

        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "Persistent Calculation Activity"

        doubleEditText = findViewById<EditText>(R.id.edt_double)
        floatEditText = findViewById<EditText>(R.id.edt_float)
        resultTextView = findViewById<TextView>(R.id.tv_multiply)
        multiplyButton = findViewById<Button>(R.id.btn_multiply)

        multiplyButton.setOnClickListener {
            if (doubleEditText.text.isNotEmpty()) {
                if (floatEditText.text.isNotEmpty()) {
                    double = doubleEditText.text.toString().toDouble()
                    float = floatEditText.text.toString().toFloat()
                    result = double * float
                    resultTextView.text = String.format("%.1f", result)
                } else {
                    Toast.makeText(this, "please enter a float", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "please enter a double", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("double", doubleEditText.text.toString())
        outState.putString("float", floatEditText.text.toString())
        outState.putString("result", result.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        double = savedInstanceState.getString("double", "0").toDouble()
        float = savedInstanceState.getString("float", "0").toFloat()
        result = savedInstanceState.getString("result", "0").toDouble()
        doubleEditText.setText(savedInstanceState.getString("double", "").toString())
        floatEditText.setText(savedInstanceState.getString("float", "").toString())
        resultTextView.text= savedInstanceState.getString("result", "").toString()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}