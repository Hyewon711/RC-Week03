package com.example.myrc_03.viewHolder

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.myrc_03.App
import com.example.myrc_03.R
import com.example.myrc_03.model.CategoryList
import com.example.myrc_03.model.UpdateList
import com.iamkamrul.expandablerecyclerviewlist.viewholder.ChildViewHolder
import kotlinx.android.synthetic.main.layout_profile_item.view.*

class CategoryListViewHolder(view:View) : ChildViewHolder(view){
    val TAG: String = "로그"
    private val profileImageView = itemView.profile_img
    private val profilenameTextView = itemView.profile_name
    private val profilestateTextView = itemView.profile_state
    private val profilesongTextView = itemView.profile_song

    fun bind(categoryList : CategoryList){
        Log.d(TAG, "CategoryListViewHolder - bind() called")
        profilenameTextView.text = categoryList.name
        profilestateTextView.text = categoryList.state
        profilesongTextView.text = categoryList.song

        // with(context) : context를 전역으로 따로 빼둠,
        // placeholder : 이미지 로딩을 시작하기 전에 보여줄 이미지 설정,
        // fallback : 이미지가 null인 경우 보여줄 이미지 설정
        Glide
            .with(App.instance)
            .load(categoryList.img)
            .placeholder(R.drawable.test_img)
            .fallback(R.drawable.no_profile_img)
            .into(profileImageView)
    }

    fun bind(updateList: UpdateList){
        Log.d(TAG, "CategoryListViewHolder - bind() called")
        profilenameTextView.text = updateList.name

        // with(context) : context를 전역으로 따로 빼둠,
        // placeholder : 이미지 로딩을 시작하기 전에 보여줄 이미지 설정,
        // fallback : 이미지가 null인 경우 보여줄 이미지 설정
        Glide
            .with(App.instance)
            .load(updateList.img)
            .placeholder(R.drawable.test_img)
            .fallback(R.drawable.no_profile_img)
            .into(profileImageView)
    }

}