package com.padc.grocery.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class GroceryMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d("token", token)
        super.onNewToken(token)
    }
}