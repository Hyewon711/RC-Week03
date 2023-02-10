package com.example.myrc_03.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myrc_03.App
import com.example.myrc_03.R
import com.example.myrc_03.adapter.CardListAdapter
import com.example.myrc_03.adapter.ShopImagePagerAdapter
import com.example.myrc_03.databinding.FragmentShopBinding
import com.example.myrc_03.model.CardList
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay

class ShopFragment : Fragment() {
    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPager: ViewPager2
    private var bannerPosition = 0
    private var bannerState = 0
    lateinit var job : Job
    lateinit var cardRecyclerview: RecyclerView
    lateinit var cardListAdapter: CardListAdapter
    lateinit var cardList: ArrayList<CardList>

    private val images = listOf(
        R.drawable.shop_banner_1,
        R.drawable.shop_banner_2,
        R.drawable.shop_banner_3,
        R.drawable.shop_banner_4,
        R.drawable.shop_banner_5,
        R.drawable.shop_banner_6,
        R.drawable.shop_banner_7,
        R.drawable.shop_banner_8,
        R.drawable.shop_banner_9,
        R.drawable.shop_banner_10
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
        var view: View = inflater.inflate(R.layout.fragment_shop, container, false)

        viewPager = view.findViewById(R.id.view_pager)
        viewPager = initialiseViewPager()
        viewPagerSlide()

        cardRecyclerview = view.findViewById(R.id.card_rv)
        CardListAdd()

        return view
    }

    // 뷰페이저2 관련 메서드
    fun viewPagerSlide() {

        bannerPosition = Int.MAX_VALUE / 2 - Math.ceil(images.size.toDouble() / 2).toInt()
        viewPager.setCurrentItem(0, false)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { if( bannerPosition == 9 ) viewPager.currentItem = 0
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

    }

    private fun initialiseViewPager() = viewPager.apply {
        adapter = ShopImagePagerAdapter(context).apply {
            items = images
            notifyDataSetChanged()
        }
    }

    // 자동 스크롤 메서드
    fun scrollJobCreate() {
        job = lifecycleScope.launchWhenResumed {
            delay(3000)
            viewPager.setCurrentItem(++bannerPosition, true)
        }
    }

    // 카드 리스트 add 메서드
    fun CardListAdd() {
        cardList = ArrayList()

        val layoutManager = GridLayoutManager(activity, 2)
        cardRecyclerview.layoutManager = layoutManager
        cardListAdapter = CardListAdapter(cardList, App.instance)
        cardRecyclerview.adapter = cardListAdapter

        // on below line we are adding data to our list
        cardList.add(CardList("","춘식이 수면바지 입은 무지","20,000원"))
        cardList.add(CardList("","차량용 무빙 도어라이트 2입세트_춘식이","39,000원"))
        cardList.add(CardList("","미니파티빔_춘식이","19,000원"))
        cardList.add(CardList("","손난로보조배터리6000mAh_어피치/춘식이","35,000원"))
        cardListAdapter.notifyDataSetChanged()
    }
    override fun onResume() {
        super.onResume()
        scrollJobCreate()
    }

    override fun onPause() {
        super.onPause()
        job.cancel()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}