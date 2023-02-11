package com.example.myrc_03.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrc_03.R
import com.example.myrc_03.adapter.CategoryAdapter
import com.example.myrc_03.adapter.UpdateAdapter
import com.example.myrc_03.databinding.FragmentHomeBinding
import com.example.myrc_03.model.Category
import com.example.myrc_03.model.CategoryList
import com.example.myrc_03.model.UpdateList
import com.iamkamrul.expandablerecyclerviewlist.listener.ExpandCollapseListener


class HomeFragment : Fragment() {
    val TAG: String = "로그"
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val categoryadapter = CategoryAdapter()
    private val updateadapter = UpdateAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        updateCategory()
        friendCategory()

        return binding.root
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    // 업데이트한 친구
    fun updateCategory() {
        Log.d(TAG, "HomeFragment - updateCategory() called")
        val data = listOf(
            Category("업데이트한 친구", listOf(
                UpdateList(
                    "서혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png"),
                UpdateList(
                    "이혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png"),
                UpdateList(
                    "장혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png"))))

        updateadapter.setExpandCollapseListener(object : ExpandCollapseListener {
            override fun onListItemExpanded(position: Int) {
            }

            override fun onListItemCollapsed(position: Int) {

            }

        })
        binding.updateListRv.setHasFixedSize(false)
        binding.updateListRv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.updateListRv.adapter = updateadapter
        updateadapter.setExpandableParentItemList(data)

    }

    fun friendCategory() {
        Log.d(TAG, "HomeFragment - friendCategory() called")
        val data = listOf(
            Category("내 멀티프로필", listOf(
                CategoryList(
                    "서혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "1상태 메세지입니다.",
                    "사건의 지평선 - 윤하"))),
            Category("생일인 친구", listOf(
                CategoryList(
                    "서혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "1상태 메세지입니다.",
                    "사건의 지평선 - 윤하"),
                CategoryList(
                    "이혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "2상태 메세지입니다.",
                    "사건의 지평선 - 윤하"),
                CategoryList(
                    "장혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "3상태 메세지입니다.", null))),
            Category("즐겨찾기", listOf(
                CategoryList(
                    "서혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "1상태 메세지입니다.",
                    "사건의 지평선 - 윤하"),
                CategoryList(
                    "이혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "2상태 메세지입니다.",
                    "사건의 지평선 - 윤하"),
                CategoryList(
                    "장혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "3상태 메세지입니다.", null))),
            Category("추천친구", listOf(
                CategoryList(
                    "서혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "1상태 메세지입니다.",
                    "사건의 지평선 - 윤하"),
                CategoryList(
                    "이혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "2상태 메세지입니다.",
                    "사건의 지평선 - 윤하"),
                CategoryList(
                    "장혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "3상태 메세지입니다.", null))),
            Category("채널", listOf(
                CategoryList(
                    "서혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "1상태 메세지입니다.",
                    "사건의 지평선 - 윤하"),
                CategoryList(
                    "이혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "2상태 메세지입니다.",
                    "사건의 지평선 - 윤하"),
                CategoryList(
                    "장혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "3상태 메세지입니다.", null))),
            Category("친구 목록", listOf(
                CategoryList(
                    "서혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "1상태 메세지입니다.",
                    "사건의 지평선 - 윤하"),
                CategoryList(
                    "이혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "2상태 메세지입니다.",
                    "사건의 지평선 - 윤하"),
                CategoryList(
                    "장혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "3상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "4상태 메세지입니다.", null),
                CategoryList(
                    "김혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "5상태 메세지입니다.",
                    "사건의 지평선 - 윤하"),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "6상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "7상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "8상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "9상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "10상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "11상태 메세지입니다.", null),

                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "12상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "13상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "14상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "15상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "16상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "17상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "18상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "19상태 메세지입니다.", null),
                CategoryList(
                    "박혜원",
                    "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                    "20상태 메세지입니다.", null)))

        )
        categoryadapter.setExpandCollapseListener(object : ExpandCollapseListener {
            override fun onListItemExpanded(position: Int) {
            }

            override fun onListItemCollapsed(position: Int) {

            }

        })

        binding.categoryListRv.setHasFixedSize(false)
        binding.categoryListRv.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        binding.categoryListRv.adapter = categoryadapter
        categoryadapter.setExpandableParentItemList(data)
    }

}