package com.padc.grocery.data.models

import android.graphics.Bitmap
import com.padc.grocery.data.vos.GroceryVO
import com.padc.grocery.network.CloudFirestoreFirebaseApiImpl
import com.padc.grocery.network.FirebaseApi
import com.padc.grocery.network.RealtimeDatabaseFirebaseApiImpl
import com.padc.grocery.network.remoteconfig.FirebaseRemoteConfigManager

object GroceryModelImpl : GroceryModel {
    //override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl
    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager

    override fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFaiure: (String) -> Unit) {
        mFirebaseApi.getGroceries(onSuccess, onFaiure)
    }

    override fun addGrocery(name: String, description: String, amount: Int, image: String) {
        mFirebaseApi.addGrocery(name, description, amount, image)
    }

    override fun removeGrocery(name: String) {
        mFirebaseApi.deleteGrocery(name)
    }

    override fun uploadImageAndUpdateGrocery(grocery: GroceryVO, image: Bitmap) {
        mFirebaseApi.uploadImageAndEditGrocery(image, grocery)
    }

    override fun setUpRemoteConfigWithDefaultValues() {
       mFirebaseRemoteConfigManager.setUpRemoteConfigWithDefaultValues()
    }

    override fun fetchRemoteConfigs() {
       mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }

    override fun getAppNameFromRemoteConfig(): String {
        return mFirebaseRemoteConfigManager.getToolbarName()
    }
}