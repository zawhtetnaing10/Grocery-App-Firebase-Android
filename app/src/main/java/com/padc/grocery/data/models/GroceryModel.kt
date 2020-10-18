package com.padc.grocery.data.models

import android.graphics.Bitmap
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.padc.grocery.data.vos.GroceryVO
import com.padc.grocery.network.FirebaseApi
import com.padc.grocery.network.remoteconfig.FirebaseRemoteConfigManager

interface GroceryModel {

    var mFirebaseApi : FirebaseApi
    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager

    fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFaiure: (String) -> Unit)

    fun addGrocery(name: String ,description : String, amount: Int, image: String)

    fun removeGrocery(name: String)

    fun uploadImageAndUpdateGrocery(grocery : GroceryVO, image : Bitmap)

    fun setUpRemoteConfigWithDefaultValues()

    fun fetchRemoteConfigs()

    fun getAppNameFromRemoteConfig() : String
}