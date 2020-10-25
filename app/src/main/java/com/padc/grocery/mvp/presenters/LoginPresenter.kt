package com.padc.grocery.mvp.presenters

import android.content.Context
import com.padc.grocery.mvp.views.LoginView

interface LoginPresenter : BasePresenter<LoginView>{
    fun onTapLogin(context : Context, email: String, password: String)
    fun onTapRegister()
}