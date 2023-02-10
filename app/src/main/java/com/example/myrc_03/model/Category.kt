package com.example.myrc_03.model

import com.iamkamrul.expandablerecyclerviewlist.model.ParentListItem

data class Category(val name:String, val friendList:List<*>) : ParentListItem {
    override fun getChildItemList(): List<*> = friendList
    override fun isInitiallyExpanded(): Boolean = true
}
