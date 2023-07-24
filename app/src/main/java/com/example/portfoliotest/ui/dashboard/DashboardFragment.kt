package com.example.portfoliotest.ui.dashboard

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.portfoliotest.R
import com.example.portfoliotest.databinding.FragmentServicesBinding
import com.example.portfoliotest.ui.notifications.projects
import me.relex.circleindicator.CircleIndicator3
import java.util.concurrent.TimeUnit

class DashboardFragment : Fragment() {

    private var _binding: FragmentServicesBinding? = null

    private var title_list = mutableListOf<String>()
    private var position_list = mutableListOf<String>()
    private var images_list = mutableListOf<Int>()
    private var comments_list = mutableListOf<String>()


    private lateinit var testimonial_list: ArrayList<servicesadapter>
    private lateinit var viewPagerHandler: Handler
    private lateinit var viewPager2: ViewPager2
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
       container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentServicesBinding.inflate(inflater, container, false)
        val rootView = binding.root

        //Define array list here
        val aeron_array = resources.getStringArray(com.example.portfoliotest.R.array.aeron_testimonial)
        val eunice_array = resources.getStringArray(com.example.portfoliotest.R.array.eunice_testimonial)
        val gian_array = resources.getStringArray(com.example.portfoliotest.R.array.gian_testimonial)
        val hans_array = resources.getStringArray(com.example.portfoliotest.R.array.hans_testimonial)
        val jerus_array = resources.getStringArray(com.example.portfoliotest.R.array.jerus_testimonial)
        val kyle_array = resources.getStringArray(com.example.portfoliotest.R.array.kyle_testimonial)
        val philippe_array = resources.getStringArray(com.example.portfoliotest.R.array.philippe_testimonial)
        val raven_array = resources.getStringArray(com.example.portfoliotest.R.array.raven_testimonial)
        val rex_array = resources.getStringArray(com.example.portfoliotest.R.array.rex_testimonial)
        val rhea_array = resources.getStringArray(com.example.portfoliotest.R.array.rhea_testimonial)
        val kristine_array = resources.getStringArray(com.example.portfoliotest.R.array.kristine_testimonial)
        val yumico_array = resources.getStringArray(com.example.portfoliotest.R.array.yumico_testimonial)
        val florence_array = resources.getStringArray(com.example.portfoliotest.R.array.miel_testimonial)


        add_to_list(aeron_array[0], aeron_array[1], R.drawable.aeron, aeron_array[2])
        add_to_list(eunice_array[0], eunice_array[1], R.drawable.eunice, eunice_array[2])
        add_to_list(gian_array[0], gian_array[1], R.drawable.gian, gian_array[2])
        add_to_list(hans_array[0], hans_array[1], R.drawable.hans, hans_array[2])
        add_to_list(jerus_array[0], jerus_array[1], R.drawable.jerus, jerus_array[2])
        add_to_list(kyle_array[0], kyle_array[0], R.drawable.kyle, kyle_array[2])
        add_to_list(philippe_array[0], philippe_array[1], R.drawable.philippe, philippe_array[2])
        add_to_list(raven_array[0], raven_array[1], R.drawable.raven, raven_array[2])
        add_to_list(rex_array[0], rex_array[1], R.drawable.rex, rex_array[2])
        add_to_list(rhea_array[0], rhea_array[1], R.drawable.rhea, rhea_array[2])
        add_to_list(kristine_array[0], kristine_array[1], R.drawable.tin, kristine_array[2])
        add_to_list(yumico_array[0], yumico_array[1], R.drawable.yumico, yumico_array[2])
        add_to_list(florence_array[0], florence_array[1], R.drawable.florence, florence_array[2])

        viewPager2 = rootView.findViewById(R.id.viewPager2)
        viewPager2.adapter = servicesadapter(title_list, position_list, images_list, comments_list)

        //Delay variables when viewpager is swiping
        val initialDelay = TimeUnit.SECONDS.toMillis(2)
        val delay = TimeUnit.SECONDS.toMillis(3) // Set the delay between each auto-scroll

        viewPagerHandler = Handler(Looper.getMainLooper())
        viewPagerHandler.postDelayed({
            // Start auto-scrolling
            viewPager2.currentItem = viewPager2.currentItem + 1
            startAutoScrolling(delay)
        }, initialDelay)


        val circleIndicator: CircleIndicator3 = rootView.findViewById(R.id.circleIndicator)
        circleIndicator.setViewPager(viewPager2)




        return rootView


    }
    private fun startAutoScrolling(delay: Long) {
        viewPagerHandler.postDelayed({
            // Scroll to the next item with a smooth animation
            viewPager2.currentItem = viewPager2.currentItem + 1

            // Repeat the auto-scrolling
            startAutoScrolling(delay)
        }, delay)
    }

    private fun add_to_list(title: String, position: String, image: Int, comments: String){
        title_list.add(title)
        position_list.add(position)
        comments_list.add(comments)
        images_list.add(image)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}