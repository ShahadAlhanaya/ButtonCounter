package com.example.buttoncounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ImageViewsActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var dayButton: Button
    lateinit var nightButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_views)

        //actionbar
        val actionbar = supportActionBar!!
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //set actionbar title
        actionbar.title = "Activity Lifecycle"

        imageView = findViewById(R.id.img_imageView)
        dayButton = findViewById(R.id.btn_day)
        nightButton = findViewById(R.id.btn_night)

        dayButton.setOnClickListener {
            imageView.setImageResource(R.drawable.day)
        }

        nightButton.setOnClickListener {
            imageView.setImageResource(R.drawable.night)
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}