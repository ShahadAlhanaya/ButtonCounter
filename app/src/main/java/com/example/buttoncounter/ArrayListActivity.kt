package com.example.buttoncounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible

class ArrayListActivity : AppCompatActivity() {

    lateinit var addButton: Button
    lateinit var getButton: Button
    lateinit var promptTextView: TextView
    lateinit var nameTextView: TextView
    lateinit var nameEditText: EditText
    lateinit var numberEditText: EditText
    lateinit var getNameLinearLayout: LinearLayout
    lateinit var enterNameLinearLayout: LinearLayout

    var namesArrayList = arrayListOf<String>()
    var count = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_list)

        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "ArrayList Activity"

        val addButton = findViewById<Button>(R.id.btn_addName)
        val getButton = findViewById<Button>(R.id.btn_getName)
        val promptTextView = findViewById<TextView>(R.id.tv_promptName)
        val nameTextView = findViewById<TextView>(R.id.tv_name)
        val nameEditText = findViewById<EditText>(R.id.edt_name)
        val numberEditText = findViewById<EditText>(R.id.edt_nameNumber)
        val getNameLinearLayout = findViewById<LinearLayout>(R.id.ll_getName)
        val enterNameLinearLayout = findViewById<LinearLayout>(R.id.ll_enterName)

        getNameLinearLayout.isVisible = false

        addButton.setOnClickListener {
            if (nameEditText.text.isNotEmpty()) {
                count--
                promptTextView.text = "Enter $count names"
                namesArrayList.add(nameEditText.text.toString())
                nameEditText.text.clear()
                if(count == 0){
                    getNameLinearLayout.isVisible = true
                    enterNameLinearLayout.isVisible = false
                }
            } else {
                Toast.makeText(this, "Enter a name", Toast.LENGTH_SHORT).show()
            }
        }

        getButton.setOnClickListener {
            if (numberEditText.text.isNotEmpty()){
                val number = numberEditText.text.toString().toInt()
                if(number in 1..10){
                    nameTextView.text = namesArrayList[number-1]
                }else{
                    Toast.makeText(this, "Enter a number between 1 and 10", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}