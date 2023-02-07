package com.example.myrc_03.model

import android.util.Log

class ProfileModel(var img: String? = null, var name: String, var state: String? = null, var song: String? = null) {
    val TAG: String = "로그"

    // 기본 생성자
    init {
        Log.d(TAG, "ProfileModel - () called")
    }
}