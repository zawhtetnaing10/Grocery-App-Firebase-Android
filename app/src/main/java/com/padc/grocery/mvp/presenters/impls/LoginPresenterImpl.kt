package com.padc.grocery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.grocery.data.models.AuthenticationModel
import com.padc.grocery.data.models.AuthenticationModelImpl
import com.padc.grocery.mvp.presenters.AbstractBasePresenter
import com.padc.grocery.mvp.presenters.LoginPresenter
import com.padc.grocery.mvp.presenters.MainPresenter
import com.padc.grocery.mvp.views.LoginView
import com.padc.grocery.mvp.views.MainView

class LoginPresenterImpl : LoginPresenter, AbstractBasePresenter<LoginView>() {

    private val mAuthenticatioModel: AuthenticationModel = AuthenticationModelImpl

    override fun onUiReady(owner: LifecycleOwner) {}

    override fun onTapLogin(email: String, password: String) {
        mAuthenticatioModel.login(email, password, onSuccess = {
            mView.navigateToHomeScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapRegister() {
        mView.navigateToRegisterScreen()
    }
}