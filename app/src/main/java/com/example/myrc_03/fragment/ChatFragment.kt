package com.example.myrc_03.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrc_03.R
import com.example.myrc_03.adapter.ChatListAdpater
import com.example.myrc_03.databinding.FragmentChatBinding
import com.example.myrc_03.databinding.FragmentHomeBinding
import com.example.myrc_03.model.ChatList
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment() {
    val TAG: String = "로그"
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    var myChatList = ArrayList<ChatList>()
    private lateinit var chatListAdapter: ChatListAdpater

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
        _binding = FragmentChatBinding.inflate(inflater, container, false)

        chatAdd()

        // 어답터를 준비 한다.
        chatListAdapter = ChatListAdpater()
        chatListAdapter.submitList(this.myChatList)

        binding.chatRv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.chatRv.adapter = chatListAdapter

        return binding.root
    }
    fun chatAdd() {
        for (i in 1..20){
            val chatList = ChatList("https://image.fmkorea.com/files/attach/new3/20221111/4366334374/716547527/5204698966/423dbeff036e95c59a8b6fb4790cd6c6.png","상대 $i", "내용입니다 $i", "$i:00")
            this.myChatList.add(chatList)
        }
    }

}