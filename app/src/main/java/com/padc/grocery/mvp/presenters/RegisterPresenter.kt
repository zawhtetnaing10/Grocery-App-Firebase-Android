package com.padc.grocery.mvp.presenters

import com.padc.grocery.mvp.views.RegisterView

interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onTapRegister(email: String, password: String, userName: String)
}