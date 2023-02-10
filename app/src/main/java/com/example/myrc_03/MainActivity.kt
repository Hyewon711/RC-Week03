package com.example.myrc_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myrc_03.databinding.ActivityMainBinding
import com.example.myrc_03.fragment.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        setupBottomNavigationView()

        Log.d(TAG, "MainActivity - onCreate() called")

        if (savedInstanceState == null ) {
            // Activity가 재생성될 시 첫 번째 화면을 표시할 필요가 없기때문에
            // 앱이 처음 실행되었는지 여부를 확인한다.
            binding.bottomNav.selectedItemId = R.id.menu_home
        }

        Log.d(TAG, "MainActivity - onCreate() called")

    }

    /* 레이아웃 설정 */
    private fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    /* BottomNavigationView Fragment Change */
    private fun setupBottomNavigationView() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, HomeFragment())
                        .commit()
                    true
                }
                R.id.menu_talk -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, ChatFragment())
                        .commit()
                    true
                }
                R.id.menu_view -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, ViewFragment())
                        .commit()
                    true
                }
                R.id.menu_shop -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, ShopFragment())
                        .commit()
                    true
                }
                R.id.menu_user -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, UserFragment())
                            .commit()
                        true
                }
                else -> false
            }
        }
        binding.bottomNav.itemIconTintList = null
    }
}
