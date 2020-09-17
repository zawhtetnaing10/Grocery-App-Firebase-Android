package com.padc.grocery.data.vos

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class GroceryVO(
    val name: String? = "",
    val description: String? = "",
    val amount: Int? = 0
)