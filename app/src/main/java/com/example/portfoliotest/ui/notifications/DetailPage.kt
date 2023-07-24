package com.example.portfoliotest.ui.notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.portfoliotest.R

class DetailPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)
        supportActionBar?.hide()



        val projects_detail = intent.getParcelableExtra<projects>("projects")
        if (projects_detail != null){
            val imageView : ImageView = findViewById(R.id.detail_image)
            val detail_title: TextView = findViewById(R.id.detail_title)
            val detail_second_title: TextView = findViewById((R.id.detail_second_title))
            val detail_tag: TextView = findViewById(R.id.detail_tag)
            val detail_description: TextView = findViewById(R.id.detail_description)

            Glide.with(this)
                .load(projects_detail.image)
                .into(imageView)
            detail_title.text = projects_detail.projectTitle
            detail_second_title.text = projects_detail.secondTitle
            detail_tag.text = projects_detail.titleTags
            detail_description.text = projects_detail.titleDescription

            //Removes detail page when clicked
            val backButton: Button = findViewById(R.id.return_button)
            backButton.setOnClickListener{
                finish()
            }
        }
    }
}