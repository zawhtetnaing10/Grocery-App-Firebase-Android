package com.padc.grocery

import android.app.Application
import com.google.firebase.messaging.FirebaseMessaging

class GroceryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseMessaging.getInstance().isAutoInitEnabled = true
    }
}