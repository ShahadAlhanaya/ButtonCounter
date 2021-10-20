package com.example.buttoncounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewContentActivity : AppCompatActivity() {

    var itemsList = arrayListOf<String>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_content)

        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "Recycler View"

        val bundle = this.intent.extras
        itemsList = bundle!!.getStringArrayList("items") as ArrayList<String>

        //initialize recyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RVAdapter(itemsList)

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}