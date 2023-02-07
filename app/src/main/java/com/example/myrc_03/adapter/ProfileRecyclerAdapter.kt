package com.example.myrc_03.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrc_03.model.ProfileModel
import com.example.myrc_03.ProfileRecyclerviewInterface
import com.example.myrc_03.R

class ProfileRecyclerAdapter(profileRecyclerviewInterface: ProfileRecyclerviewInterface): RecyclerView.Adapter<ProfileViewHolder>() {
    private var profileModelList = ArrayList<ProfileModel>()
    private var profileRecyclerviewInterface : ProfileRecyclerviewInterface? = null
    val TAG: String = "로그"

    // 생성자
    init {
        this.profileRecyclerviewInterface = profileRecyclerviewInterface
    }

    // 뷰홀더가 생성되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        // 연결할 레이아웃 설정
        return ProfileViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_profile_item, parent, false), this.profileRecyclerviewInterface!!)
    }

    // 뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        Log.d(TAG, "ProfileRecyclerAdapter - onBindViewHolder() called")
        holder.bind(this.profileModelList[position])
        // 클릭 리스너 설정
    }

    // 아이템 목록 수
    override fun getItemCount(): Int {
        return this.profileModelList.size
    }

    // item 넣기
    fun submitList(profileModelList: ArrayList<ProfileModel>) {
        // 현재 modelList와 외부에서 받아온 modelList와 연결
        this.profileModelList = profileModelList
    }
}