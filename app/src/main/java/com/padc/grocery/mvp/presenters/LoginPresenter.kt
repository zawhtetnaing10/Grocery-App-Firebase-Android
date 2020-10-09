package com.padc.grocery.mvp.presenters

import com.padc.grocery.mvp.views.LoginView

interface LoginPresenter : BasePresenter<LoginView>{
    fun onTapLogin(email: String, password: String)
    fun onTapRegister()
}