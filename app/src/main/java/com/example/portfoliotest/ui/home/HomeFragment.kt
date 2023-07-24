package com.example.portfoliotest.ui.home

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.portfoliotest.databinding.FragmentAboutBinding
import com.bumptech.glide.Glide



class HomeFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root


        //val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
          //  textView.text = it

            Glide.with(this)
                .load(com.example.portfoliotest.R.drawable.about)
                .placeholder(com.example.portfoliotest.R.drawable.about)
                .centerCrop()
                .circleCrop()
                .into(binding.imageView4)

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}