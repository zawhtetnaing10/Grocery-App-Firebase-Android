package com.padc.grocery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.grocery.mvp.views.BaseView

interface BasePresenter<V: BaseView> {
    fun onUiReady(owner: LifecycleOwner)
    fun initPresenter(view: V)
}