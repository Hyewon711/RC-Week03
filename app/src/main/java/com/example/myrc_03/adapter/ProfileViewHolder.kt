package com.example.myrc_03.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myrc_03.App
import com.example.myrc_03.model.ProfileModel
import com.example.myrc_03.ProfileRecyclerviewInterface
import com.example.myrc_03.R
import kotlinx.android.synthetic.main.layout_profile_item.view.*

// 커스텀 뷰홀더
class ProfileViewHolder(itemView: View,
                        recyclerviewInterface: ProfileRecyclerviewInterface):
                        RecyclerView.ViewHolder(itemView),
                        View.OnClickListener
{
    val TAG: String = "로그"

    private val profileImageView = itemView.profile_img
    private val profilenameTextView = itemView.profile_name
    private val profilestateTextView = itemView.profile_state
    private val profilesongTextView = itemView.profile_song

    private var profileRecyclerviewInterface : ProfileRecyclerviewInterface? = null
    
    // 기본 생성자 
    init {
        Log.d(TAG, "ProfileViewHolder - () called")
        // 자기 자신에게 setOnClickListener를 걸어준다.
        itemView.setOnClickListener(this)
        this.profileRecyclerviewInterface = recyclerviewInterface
    }

    // 데이터와 뷰를 묶는다.

    fun bind(profileModel: ProfileModel) {
        Log.d(TAG, "ProfileViewHolder - bind() called")
        profilenameTextView.text = profileModel.name
        profilestateTextView.text = profileModel.state
        profilesongTextView.text = profileModel.song

        // with(context) : context를 전역으로 따로 빼둠,
        // placeholder : 이미지 로딩을 시작하기 전에 보여줄 이미지 설정,
        // fallback : 이미지가 null인 경우 보여줄 이미지 설정
        Glide
            .with(App.instance)
            .load(profileModel.img)
            .placeholder(R.drawable.test_img)
            .fallback(R.drawable.no_profile_img)
            .into(profileImageView)
    }

    override fun onClick(v: View?) {
        Log.d(TAG, "ProfileViewHolder - onClick() called")
        this.profileRecyclerviewInterface?.onItemClicked(bindingAdapterPosition)
    }

}