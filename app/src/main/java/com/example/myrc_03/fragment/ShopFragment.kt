package com.example.myrc_03.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myrc_03.App
import com.example.myrc_03.R
import com.example.myrc_03.adapter.CardAdapter
import com.example.myrc_03.adapter.CardListAdapter
import com.example.myrc_03.adapter.ShopImagePagerAdapter
import com.example.myrc_03.databinding.FragmentShopBinding
import com.example.myrc_03.model.Card
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
    lateinit var card: ArrayList<Card>
    lateinit var cardAdapter: CardAdapter


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
        cardRecyclerview = view.findViewById(R.id.card_top_rv)
        CardAdd()

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

    // 카드 top add 메서드
    fun CardAdd() {
        card = ArrayList()

        val layoutManager = LinearLayoutManager(activity)
        cardRecyclerview.layoutManager = layoutManager
        cardAdapter = CardAdapter(card, App.instance)
        cardRecyclerview.adapter = cardAdapter

        card.add(Card("https://user-images.githubusercontent.com/84006341/218098452-07f34ba0-e0b9-4e52-8497-c54bb9031b3b.png","프렌즈","","이 아이템 어때요?","귀여운 프렌즈 아이템과 함께 일상의 즐거움을 찾아보세요!", arrayListOf(
            CardList("https://user-images.githubusercontent.com/84006341/218097799-b6c18be7-766d-4d2d-9318-561283acb702.png","춘식이 수면바지 입은 무지","20,000원"),
            CardList("https://user-images.githubusercontent.com/84006341/218097802-131a4430-8828-45e5-865d-c6558e734706.png","차량용 무빙도어라이트 2입세트","39,000원"),
            CardList("https://user-images.githubusercontent.com/84006341/218098112-802a132b-70a4-4142-b5ca-5027921d3523.png","미니파티빔_춘식이","19,000원"),
            CardList("https://user-images.githubusercontent.com/84006341/218097805-b6aca508-7f02-4da3-825e-d8353a1eb169.png","손난로보조배터리6000mAh_어피치/춘식이","35,000원"))))
        card.add(Card("https://user-images.githubusercontent.com/84006341/218098455-7d50928b-a30e-4112-8e33-56f4a2c26757.png","메이커스","전체보기 〉","지금 주목받고 있어요!","트렌디한 당신을 위해 주목받는 신상만 추렸어요.", arrayListOf(
            CardList("https://user-images.githubusercontent.com/84006341/218097807-1c66477a-b295-4708-93e6-7d9d4bb84775.png","슈펜 봄 스퀘어 리본 쿠션 플랫 슈즈","19,900원"),
            CardList("https://user-images.githubusercontent.com/84006341/218097811-76759c87-fc78-4160-9143-fd994bf53f97.png","스톰탁주 전용잔 기획세트","25,000원"),
            CardList("https://user-images.githubusercontent.com/84006341/218097815-c3945b07-0d53-40ec-9c5a-f1d22eafb8d2.png","[뷰티위크] 티르티르 센텔라 폼 클렌징","11,400원"),
            CardList("https://user-images.githubusercontent.com/84006341/218097818-d2f2b9fd-b704-4496-bdf3-9ad9b56d2c64.png","업사이클링 리너지가루로 만든, 리하베스트 그래놀라","9,600원"))))
        card.add(Card("https://user-images.githubusercontent.com/84006341/218098455-7d50928b-a30e-4112-8e33-56f4a2c26757.png","메이커스","","고객 증명, 이 제품은 믿고 사세요","만족도 높은데 주문도 많이 받은 신뢰의 리스트", arrayListOf(
            CardList("https://user-images.githubusercontent.com/84006341/218098119-c239d0ac-1851-4e23-aa76-171d6e8c3905.png","26년전통맛집 귀빈정 제철 향긋한 봄동 겉절이 1.5kg","13,700원"),
            CardList("https://user-images.githubusercontent.com/84006341/218097787-636a9229-8db2-4b53-a836-0785f34fdda6.png","[뷰티위크] 티르티르 도자기 물광크림 50ml/100ml/50ml+10ml","19,600원"),
            CardList("https://user-images.githubusercontent.com/84006341/218097789-2e8f1fd9-6ce0-4cf9-829f-60ca7cfcd459.png","셀렉스 프로틴 음료 190ml x 24팩 (오리지널/로우슈거)","22,900원"),
            CardList("https://user-images.githubusercontent.com/84006341/218097793-d779cb5d-30aa-40fb-978b-a860624655d4.png","천상의 맛, 터키 전통 디저트 카이막","12,000원"))))

        cardAdapter.notifyDataSetChanged()

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