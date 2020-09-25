package com.padc.grocery.delegates

import com.padc.grocery.data.vos.GroceryVO

interface GroceryViewItemActionDelegate{
    fun onTapDeleteGrocery(name : String)
    fun onTapEditGrocery(name: String, description: String, amount: Int)
    fun onTapFileUpload(grocery: GroceryVO)
}