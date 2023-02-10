package com.example.myrc_03.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.myrc_03.R
import com.example.myrc_03.adapter.ImagePagerAdapter
import com.example.myrc_03.databinding.FragmentUserBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import java.lang.Math.ceil

class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private var bannerPosition = 0
    private var bannerState = 0
    lateinit var job : Job

    private val images = listOf(
        R.drawable.ad_banner_1,
        R.drawable.ad_banner_2,
        R.drawable.ad_banner_3,
        R.drawable.ad_banner_4,
        R.drawable.ad_banner_5
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_user, container, false)

        tabLayout = view.findViewById(R.id.tabs)
        viewPager = view.findViewById(R.id.ad_viewpager)
        viewPager = initialiseViewPager()

        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        bannerPosition = Int.MAX_VALUE / 2 - ceil(images.size.toDouble() / 2).toInt()
        viewPager.setCurrentItem(0, false)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { if(bannerPosition == 4 )
                viewPager.currentItem = 0
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {  //사용자가 스크롤 했을때 position 수정
                super.onPageSelected(position)
                bannerPosition = position

            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                bannerState = state
                when (state) {
                    ViewPager2.SCROLL_STATE_IDLE ->{
                        if (!job.isActive) scrollJobCreate()
                    }
                    ViewPager2.SCROLL_STATE_DRAGGING -> job.cancel()
                    ViewPager2.SCROLL_STATE_SETTLING -> {}
                }
            }
        })

        return view
    }

    private fun initialiseViewPager() = viewPager.apply {
        adapter = ImagePagerAdapter(context).apply {
            items = images
            notifyDataSetChanged()
        }
    }

    // 자동 스크롤 함수
    fun scrollJobCreate() {
        job = lifecycleScope.launchWhenResumed {
            delay(5000)
            viewPager.setCurrentItem(++bannerPosition, true)
        }
    }

    override fun onResume() {
        super.onResume()
        scrollJobCreate()
    }

    override fun onPause() {
        super.onPause()
        job.cancel()
    }

}
