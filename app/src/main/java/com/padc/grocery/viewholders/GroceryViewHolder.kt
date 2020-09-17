package com.padc.grocery.viewholders

import android.view.View
import com.padc.grocery.data.vos.GroceryVO
import com.padc.grocery.delegates.GroceryViewItemActionDelegate
import com.zg.burgerjoint.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.view_holder_grocery_item.view.*

class GroceryViewHolder(itemView: View, private val mDelegate: GroceryViewItemActionDelegate) :
    BaseViewHolder<GroceryVO>(itemView) {

    override fun bindData(data: GroceryVO) {
        itemView.tvTitle.text = data.name
        itemView.tvDescription.text = data.description
        itemView.tvCount.text = "x ${data.amount.toString()}"

        itemView.btnDelete.setOnClickListener {
            mDelegate.onTapDeleteGrocery(data.name ?: "")
        }

        itemView.btnEdit.setOnClickListener {
            mDelegate.onTapEditGrocery(data.name ?: "", data.description ?: "", data.amount ?: 0)
        }
    }
}