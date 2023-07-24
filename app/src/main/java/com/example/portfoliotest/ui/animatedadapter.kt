package com.example.portfoliotest.ui

import android.graphics.pdf.PdfDocument.Page
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.portfoliotest.R

class animatedadapter(private val animationFiles: List<Int>, private var description: List<String>) :
    RecyclerView.Adapter<animatedadapter.PagerViewHolder>(){

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animationView: LottieAnimationView = itemView.findViewById(R.id.animatedCarousel)
        val animation_description: TextView = itemView.findViewById(R.id.animated_description)

        init {
            //infinitely plays the animation
            animationView.repeatCount = LottieDrawable.INFINITE
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animated_item, parent, false)
        return PagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animationFiles.size
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        val animationFile = animationFiles[position]
        holder.animation_description.text = description[position]
        holder.animationView.setAnimation(animationFile)
        holder.animationView.playAnimation()
    }
}