package com.padc.grocery.mvp.presenters

import com.padc.grocery.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView> {
    fun onTapAddGrocery(name: String, description: String, amount: Int)
}
