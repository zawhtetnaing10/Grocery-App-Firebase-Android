package com.padc.grocery.data.models

import com.padc.grocery.data.vos.GroceryVO
import com.padc.grocery.network.FirebaseApi

interface GroceryModel {

    var mFirebaseApi : FirebaseApi

    fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFaiure: (String) -> Unit)

    fun addGrocery(name: String ,description : String, amount: Int)

    fun removeGrocery(name: String)

    fun editGrocery(name: String, description: String, amount: Int)
}