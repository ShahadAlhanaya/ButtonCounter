package com.example.buttoncounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SimpleCalculatorActivity : AppCompatActivity() {
    lateinit var addButton : Button
    lateinit var subtractButton : Button
    lateinit var multiplyButton : Button
    lateinit var divideButton : Button
    lateinit var resultTextView : TextView
    lateinit var double1EditText: EditText
    lateinit var double2EditText: EditText

    var result = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_calculator)

        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "Simple Calculator"

        subtractButton = findViewById(R.id.btn_simpleMinus)
        addButton = findViewById(R.id.btn_simplePlus)
        multiplyButton = findViewById(R.id.btn_simpleMultiply)
        divideButton = findViewById(R.id.btn_simpleDivide)
        resultTextView = findViewById(R.id.tv_simpleResult)
        double1EditText = findViewById(R.id.edt_simpleDouble1)
        double2EditText = findViewById(R.id.edt_simpleDouble2)

        addButton.setOnClickListener {
            if(checkFields()){
                resultTextView.text = add(double1EditText.text.toString().toDouble(),double2EditText.text.toString().toDouble())
            }
        }
        subtractButton.setOnClickListener {
            if(checkFields()){
                resultTextView.text = subtract(double1EditText.text.toString().toDouble(),double2EditText.text.toString().toDouble())
            }
        }
        multiplyButton.setOnClickListener {
            if(checkFields()){
                resultTextView.text = multiply(double1EditText.text.toString().toDouble(),double2EditText.text.toString().toDouble())
            }
        }
        divideButton.setOnClickListener {
            if(checkFields()){
                resultTextView.text = divide(double1EditText.text.toString().toDouble(),double2EditText.text.toString().toDouble())
            }
        }
    }

    private fun add(double1 :Double, double2 :Double) :String{
        return String.format("%.2f", double1+double2)
    }
    private fun subtract(double1 :Double, double2 :Double) :String{
        return String.format("%.2f", double1-double2)
    }
    private fun multiply(double1 :Double, double2 :Double) :String{
        return String.format("%.2f", double1*double2)
    }
    private fun divide(double1 :Double, double2 :Double) :String{
        if(double2 == 0.0){
            return "You can't divide by 0"
        }
        return String.format("%.2f", double1/double2)
    }
    private fun checkFields() :Boolean{
        return if (double1EditText.text.isNotEmpty()) {
            if (double2EditText.text.isNotEmpty()) {
                true
            } else {
                Toast.makeText(this, "you need to enter both numbers", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            Toast.makeText(this, "please enter a double", Toast.LENGTH_SHORT).show()
            false
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}