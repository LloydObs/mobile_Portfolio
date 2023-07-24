package com.example.portfoliotest.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.portfoliotest.R
import com.example.portfoliotest.databinding.FragmentPortfolioBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentPortfolioBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var projectsAdapter: projectsadapter
    private lateinit var viewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPortfolioBinding.inflate(inflater, container, false)
        val view = binding.root

        //instantiate view model here
        viewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)
        recyclerView = binding.itemlist
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //Connect Adapter
        projectsAdapter = projectsadapter(ArrayList())
        recyclerView.adapter = projectsAdapter

        //Connect View Model to the list of projects
        viewModel.projectsList.observe(viewLifecycleOwner, { projectsList ->
            projectsAdapter.projectsList.clear()
            projectsAdapter.projectsList.addAll(projectsList)
            projectsAdapter.notifyDataSetChanged()
        })
        //On click item to view detail page
        projectsAdapter.onItemClick = { project ->
            val intent = Intent(requireActivity(), DetailPage::class.java)
            intent.putExtra("projects", project)
            startActivity(intent)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}