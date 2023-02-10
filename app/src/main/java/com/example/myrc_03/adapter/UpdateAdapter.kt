package com.example.myrc_03.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myrc_03.R
import com.example.myrc_03.model.Category
import com.example.myrc_03.model.CategoryList
import com.example.myrc_03.model.UpdateList
import com.example.myrc_03.viewHolder.CategoryListViewHolder
import com.example.myrc_03.viewHolder.CategoryViewHolder
import com.iamkamrul.expandablerecyclerviewlist.adapter.ExpandableRecyclerAdapter
import com.iamkamrul.expandablerecyclerviewlist.model.ParentListItem

class UpdateAdapter : ExpandableRecyclerAdapter<CategoryViewHolder, CategoryListViewHolder>(){
    val TAG: String = "로그"

    override fun onCreateParentViewHolder(parentViewGroup: ViewGroup
    ): CategoryViewHolder {
        Log.d(TAG, "CategoryAdapter - onCreateParentViewHolder() called")
        val view = LayoutInflater.from(parentViewGroup.context).inflate(R.layout.item_category, parentViewGroup, false)
        return CategoryViewHolder(view)
    }

    override fun onBindParentViewHolder(parentViewHolder: CategoryViewHolder, position: Int, parentListItem: ParentListItem) {
        val data = parentListItem as Category
        parentViewHolder.bind(data)
    }

    override fun onCreateChildViewHolder(parentViewGroup: ViewGroup): CategoryListViewHolder {
        val view = LayoutInflater.from(parentViewGroup.context).inflate(R.layout.layout_profile_item_horizontal, parentViewGroup, false)
        return CategoryListViewHolder(view)
    }

    override fun onBindChildViewHolder(childViewHolder: CategoryListViewHolder, position: Int, childListItem: Any) {
        val data = childListItem as UpdateList
        Log.d(TAG, "CategoryAdapter - onBindChildViewHolder() called")
        childViewHolder.bind(data)
    }
}