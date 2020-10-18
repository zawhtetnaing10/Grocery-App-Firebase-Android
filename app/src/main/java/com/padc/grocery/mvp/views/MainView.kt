package com.padc.grocery.mvp.views

import com.padc.grocery.data.vos.GroceryVO

interface MainView : BaseView {
    fun displayToolbarTitle(title: String)
    fun showGroceryData(groceryList: List<GroceryVO>)
    fun showGroceryDialog(name: String, description: String, amount: String)
    fun showErrorMessage(message: String)
    fun openGallery()
}