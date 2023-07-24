package com.example.portfoliotest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import com.example.portfoliotest.MainActivity
import com.example.portfoliotest.R
import me.relex.circleindicator.CircleIndicator3


class animated_fragment : Fragment() {

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_animated_fragment, container, false)
        val viewPager: ViewPager2 = view.findViewById(R.id.animatedPager)
        val animationFiles = listOf(R.raw.coding_boy, R.raw.playing, R.raw.traveling)
        val getDescription = resources.getStringArray(R.array.splash_description)
        val descriptionList = listOf(getDescription[0],getDescription[1], getDescription[2])
        val adapter = animatedadapter(animationFiles,descriptionList)
        viewPager.adapter = adapter
        val circleIndicator: CircleIndicator3 = view.findViewById(R.id.indicator)
        circleIndicator.setViewPager(viewPager)

        val button = view.findViewById<Button>(R.id.skipButton)

        //Jetpack navigation if button is clicked, jumps to main page.
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        navController = navHostFragment.navController
        button.setOnClickListener{
            navController.navigate(R.id.action_animated_fragment_to_navigation_about)
        }

        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        //Removes the navigation bar when started in specific fragment
        super.onActivityCreated(savedInstanceState)
        (activity as MainActivity).setBottomNavigationVisibility(View.GONE)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as MainActivity).setBottomNavigationVisibility(View.VISIBLE)
    }


}