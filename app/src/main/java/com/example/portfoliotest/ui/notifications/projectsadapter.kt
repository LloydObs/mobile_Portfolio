package com.example.portfoliotest.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.portfoliotest.R



class projectsadapter(val projectsList: ArrayList<projects>) : RecyclerView.Adapter<projectsadapter.ProjectsViewHolder>() {

    var onItemClick: ((projects) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ProjectsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return projectsList.size
    }

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        val projects = projectsList[position]
        holder.bind(projects)
    }

    inner class ProjectsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.project_image)
        private val projectTitle: TextView = itemView.findViewById(R.id.project_title)
        private val secondTitleView: TextView = itemView.findViewById(R.id.second_title)
        private val tagView: TextView = itemView.findViewById(R.id.title_tags)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val project = projectsList[position]
                    onItemClick?.invoke(project)
                }
            }
        }
        //Bind all items for view model
        fun bind(projects: projects) {
            Glide.with(itemView)
                .load(projects.image)
                .into(imageView)
            projectTitle.text = projects.projectTitle
            secondTitleView.text = projects.secondTitle
            tagView.text = projects.titleTags
        }
    }
}