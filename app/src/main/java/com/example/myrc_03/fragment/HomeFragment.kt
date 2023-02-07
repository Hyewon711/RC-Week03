package com.example.myrc_03.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrc_03.ProfileRecyclerviewInterface
import com.example.myrc_03.R
import com.example.myrc_03.adapter.ProfileRecyclerAdapter
import com.example.myrc_03.databinding.FragmentHomeBinding
import com.example.myrc_03.model.ProfileModel

class HomeFragment : Fragment(), ProfileRecyclerviewInterface {
    val TAG: String = "로그"
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    // 데이터를 담을 그릇, 배열
    var profileModelList = ArrayList<ProfileModel>()
    private lateinit var profileRecyclerAdapter: ProfileRecyclerAdapter

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

        // item add
        addItem()
        // 어댑터 인스턴스 생성
        profileRecyclerAdapter = ProfileRecyclerAdapter(this)
        profileRecyclerAdapter.submitList(this.profileModelList)

        // 리사이클러뷰 설정
        // xml의 profile_recyclerview 방향 등 설정
        binding.profileRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        // 어댑터 장착
        binding.profileRecyclerview.adapter = profileRecyclerAdapter


        return binding.root
    }

    fun addItem() {
        Log.d(TAG, "반복문 돌리기 전 this.profileModelList : ${this.profileModelList.size}")

        for (i in 1..30) {
            if (i % 2 == 0) {
                var profileModel =
                    ProfileModel(
                        name = "서혜원 $i",
                        img = "https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png",
                        state = "$i 번째 프로필 입니다."
                    )
                this.profileModelList.add(profileModel)
            } else {
                var profileModel =
                    ProfileModel(
                        name = "서혜원 $i",
                        img = null,
                        state = "$i 번째 프로필 입니다.",
                        song = "사건의 지평선 - 윤하"
                    )
                this.profileModelList.add(profileModel)
            }
            Log.d(TAG, "반복문 돌린 후 this.profileModelList : ${this.profileModelList.size}")
        }
    }

    override fun onItemClicked(position: Int) {
        Log.d(TAG, "MainActivity - onItemClicked() called")
        val title: String = this.profileModelList[position].name ?: ""

        AlertDialog.Builder(activity)
            .setTitle(title)
            .setMessage("$title 프로필 보기 입니다.")
            .setPositiveButton("확인") { dialog, id ->
            }.show()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}