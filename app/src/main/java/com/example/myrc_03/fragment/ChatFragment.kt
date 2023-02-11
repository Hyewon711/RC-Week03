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
import com.example.myrc_03.model.Card
import com.example.myrc_03.model.ChatList
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment() {
    val TAG: String = "로그"
    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    var chat = ArrayList<ChatList>()
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
        chatListAdapter.submitList(this.chat)

        binding.chatRv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.chatRv.adapter = chatListAdapter

        return binding.root
    }
    fun chatAdd() {
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234007-14c371d6-c59d-4b43-a89d-b3f852d40192.png","서혜원","사진 4장을 보냈습니다.","2월 11일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234008-30028ab5-0126-4299-9436-92aa16c61b18.png","카카오톡","[PC버전 자동로그인]","2월 11일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234010-c0221632-9c69-4227-b1bb-67f2596c0370.png","채널 춘식이","(광고)[채널춘식이] 춘식이는 스타벅스로 출근 중! 귀여움 더블샷 추가한 [바리스타 춘식 에디션] 확인하세요.","2월 10일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234011-e72e2d9c-2eb1-48d6-9a64-cfb86baa0e45.png","카카오톡 선물하기","후기를 기다리는 상품이 있어요.","2월 7일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234012-e2137dfb-a259-4c4e-a447-318cc522c875.png","씨씨오씨","(광고)발렌타인데이 커플데이터 추천@","2월 6일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234013-1037f817-7ff7-484d-9df5-6894d4b9afdf.png","우체국","간편사전접수플러스를 이용하여 접수가 완료되었습니다.","2월 6일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234014-fcdffe0c-c0b3-4a57-8a05-d7cdebf4cc09.png","야놀자","(광고) 2월에는 최대 2O,OOO원 할인","2월 6일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234015-9196c8dc-7b53-48aa-b52e-7a864f1dbafe.png","NH멤버스","안녕하세요. NH농협은행 NH멤버스 입니다","2월 6일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234016-f6052a62-ce9e-49d9-9e31-998f5f7cf29f.png","인프런","(광고)'토비의 스프링'저자 토비님의 스프링 2막 인프런에서 함께합니다!","2월 5일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234017-5883fc49-96df-42cc-a5f8-323925011103.png","NICE지키미","[NICE지키미]서*원님 안녕하세요.","2월 5일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234019-98909e12-d38b-4830-b996-7431e58a2907.png","CJ대한통운","[CJ 대한통운 택배] 서혜원 고객님 안녕하세요...","2월 4일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234021-1fe96ca3-6116-4bdb-ad38-2cf2aa807710.png","010가상계좌","[ 010가상계좌 ] 입금 완료","2월 4일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234022-e6cd1f59-b7f3-4359-8b83-decb7e1f658a.png","카카오페이","결제가 완료되었습니다.","2월 4일"))
        chat.add(ChatList("https://user-images.githubusercontent.com/84006341/218234006-3b630cb5-e7b9-454a-bdec-674b6d42681d.png","테이블링","안녕하세요! 우와 홍대본점 입니다.","2월 3일"))
    }

}