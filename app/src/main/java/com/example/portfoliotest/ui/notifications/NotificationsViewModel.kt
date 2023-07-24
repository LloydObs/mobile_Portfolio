package com.example.portfoliotest.ui.notifications

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.portfoliotest.R

class NotificationsViewModel(application: Application) : AndroidViewModel(application){
    private val _projectsList = MutableLiveData<List<projects>>()
    val projectsList: LiveData<List<projects>> get() = _projectsList

    init {
        // Initialize your projectsList with the data
        val tacdesk_array = application.resources.getStringArray(R.array.project_tacdesk)
        val cmos_array = application.resources.getStringArray(R.array.project_cmos)
        val busreserb_array = application.resources.getStringArray(R.array.project_busreserb)
        val drowsy_array = application.resources.getStringArray(R.array.project_ai)
        val astrophotography_array = application.resources.getStringArray(R.array.hobbies_astro)
        val chatserver_array = application.resources.getStringArray(R.array.subproject_chatserver)
        val pong_array = application.resources.getStringArray(R.array.subproject_pong)
        val snake_array = application.resources.getStringArray(R.array.subproject_snake)
        val projects = listOf(
            projects(R.drawable.tacdesk_main, tacdesk_array[0], tacdesk_array[1], tacdesk_array[2], tacdesk_array[3]),
            projects(R.drawable.cmos, cmos_array[0], cmos_array[1], cmos_array[2], cmos_array[3]),
            projects(R.drawable.busreserve, busreserb_array[0], busreserb_array[1], busreserb_array[2], busreserb_array[3]),
            projects(R.drawable.about, drowsy_array[0], drowsy_array[1], drowsy_array[2], drowsy_array[3]),
            projects(R.drawable.pong, pong_array[0], pong_array[1], pong_array[2], pong_array[3]),
            projects(R.drawable.snake_game, snake_array[0], snake_array[1], snake_array[2], snake_array[3]),
            projects(R.drawable.chat_server, chatserver_array[0], chatserver_array[1], chatserver_array[2], chatserver_array[3]),
            projects(R.drawable.astro_moon, astrophotography_array[0], astrophotography_array[1], astrophotography_array[2], astrophotography_array[3])
        )
        _projectsList.value = projects
    }
}



/*
* val tacdesk_array = resources.getStringArray(com.example.portfoliotest.R.array.project_tacdesk)
        val cmos_array = resources.getStringArray(com.example.portfoliotest.R.array.project_cmos)
        val busreserb_array = resources.getStringArray(com.example.portfoliotest.R.array.project_busreserb)
        val drowsy_array = resources.getStringArray(com.example.portfoliotest.R.array.project_ai)
        val astrophotography_array = resources.getStringArray(com.example.portfoliotest.R.array.hobbies_astro)
        val chatserver_array = resources.getStringArray(com.example.portfoliotest.R.array.subproject_chatserver)
        val pong_array = resources.getStringArray(com.example.portfoliotest.R.array.subproject_pong)
        val snake_array = resources.getStringArray(com.example.portfoliotest.R.array.subproject_snake)*/