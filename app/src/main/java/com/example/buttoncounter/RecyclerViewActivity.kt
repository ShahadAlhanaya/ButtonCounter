package com.example.buttoncounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent




class RecyclerViewActivity : AppCompatActivity() {

    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var editText4: EditText
    lateinit var button: Button

    var itemsList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "Recycler View"

        editText1 = findViewById(R.id.edt_rv1)
        editText2 = findViewById(R.id.edt_rv2)
        editText3 = findViewById(R.id.edt_rv3)
        editText4 = findViewById(R.id.edt_rv4)
        button = findViewById(R.id.btn_showInRv)

        button.setOnClickListener {
            if(editText1.text.isNotEmpty()){
                itemsList.add(editText1.text.toString())
                if(editText2.text.isNotEmpty()) itemsList.add(editText2.text.toString())
                if(editText3.text.isNotEmpty()) itemsList.add(editText3.text.toString())
                if(editText4.text.isNotEmpty()) itemsList.add(editText4.text.toString())

                val bundle = Bundle()
                bundle.putStringArrayList("items", itemsList)
                val intent = Intent(this,RecyclerViewContentActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)

                itemsList.clear()

            }else{
                Toast.makeText(this,"please enter items",Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}