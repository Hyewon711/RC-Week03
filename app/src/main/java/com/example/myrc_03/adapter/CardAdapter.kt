package com.example.myrc_03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myrc_03.App
import com.example.myrc_03.R
import com.example.myrc_03.databinding.CardTopItemBinding
import com.example.myrc_03.model.Card
import com.example.myrc_03.model.CardList
import kotlinx.android.synthetic.main.card_top_item.view.*

class CardAdapter(private val card: ArrayList<Card>, private val context: Context): RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    inner class CardViewHolder(private val binding: CardTopItemBinding): RecyclerView.ViewHolder(binding.root) {
        private val imageView = itemView.card_logo
        private val nameTextView = itemView.card_name
        private val nameSubTextView = itemView.card_name_sub
        private val titleTextView = itemView.card_title
        private val contentTextView = itemView.card_content
        private var cardList = ArrayList<CardList>()

        fun bind(card: Card) {
            nameTextView.text = card.name
            nameSubTextView.text = card.name_sub
            titleTextView.text = card.title
            contentTextView.text = card.content
            cardList = card.card

            Glide
                .with(App.instance)
                .load(card.img)
                .placeholder(R.drawable.test_img)
                .fallback(R.drawable.no_profile_img)
                .into(imageView)

            binding.cardRv.apply {
                adapter = CardListAdapter(cardList, App.instance)
                layoutManager = GridLayoutManager(App.instance, 2)
                setHasFixedSize(true)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = CardTopItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        // 해당 번째의 아이템을 가져온다.
        val cardItem = this.card[position]
        // 데이터와 뷰 묶음
        holder.bind(cardItem)
    }

    override fun getItemCount(): Int {
        return card.size
    }

}