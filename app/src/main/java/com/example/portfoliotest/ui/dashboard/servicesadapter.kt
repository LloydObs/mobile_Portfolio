package com.example.portfoliotest.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class servicesadapter(private var title: List<String>,
                      private var details: List<String>,
                      private var images: List<Int>,
                      private var comments: List<String>): RecyclerView.Adapter<servicesadapter.Pager2ViewHolder>(){

    inner class Pager2ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val item_name: TextView = itemView.findViewById(com.example.portfoliotest.R.id.testimonial_name)
        val item_position:TextView = itemView.findViewById(com.example.portfoliotest.R.id.testimonial_position)
        val item_comment: TextView = itemView.findViewById(com.example.portfoliotest.R.id.testimonial_comment)
        val item_image: ImageView = itemView.findViewById(com.example.portfoliotest.R.id.testimonial_profile)


    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): servicesadapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(com.example.portfoliotest.R.layout.testimonials_item, parent, false))
    }

    override fun onBindViewHolder(holder: servicesadapter.Pager2ViewHolder, position: Int) {
        holder.item_name.text = title[position]
        holder.item_comment.text = comments[position]
        holder.item_position.text = details[position]
        //Load images into glide dahil nag cacrash pag hinde
        Glide.with(holder.itemView.context)
            .load(images[position])
            .circleCrop()
            .into(holder.item_image)
    }

    override fun getItemCount(): Int {
        return title.size
    }
}