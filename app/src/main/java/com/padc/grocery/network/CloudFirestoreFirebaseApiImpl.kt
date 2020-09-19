package com.padc.grocery.network

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.padc.grocery.data.vos.GroceryVO

object CloudFirestoreFirebaseApiImpl : FirebaseApi {

    val db = Firebase.firestore

    override fun getGroceries(
        onSuccess: (groceries: List<GroceryVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
//        db.collection("groceries")
//            .get()
//            .addOnSuccessListener { result ->
//                val groceriesList: MutableList<GroceryVO> = arrayListOf()
//                for (document in result) {
//                    val data = document.data
//                    var grocery = GroceryVO()
//                    grocery.name = data["name"] as String
//                    grocery.description = data["description"] as String
//                    grocery.amount = (data["amount"] as Long).toInt()
//                    groceriesList.add(grocery)
//                }
//                onSuccess(groceriesList)
//            }
//            .addOnFailureListener { exception ->
//                onFialure(exception.message ?: "Please check connection")
//            }
        db.collection("groceries")
            .addSnapshotListener { value, error ->
                error?.let {
                    onFialure(it.message ?: "Please check connection")
                } ?: run{
                    val groceriesList: MutableList<GroceryVO> = arrayListOf()

                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val data = document.data
                        val grocery = GroceryVO()
                        grocery.name = data?.get("name") as String
                        grocery.description = data["description"] as String
                        grocery.amount = (data["amount"] as Long).toInt()
                        groceriesList.add(grocery)
                    }
                    onSuccess(groceriesList)
                }
            }
    }

    override fun addGrocery(name: String, description: String, amount: Int) {
        val groceryMap = hashMapOf(
            "name" to name,
            "description" to description,
            "amount" to amount.toLong()
        )

        db.collection("groceries")
            .document(name)
            .set(groceryMap)
            .addOnSuccessListener { Log.d("Success", "Successfully added grocery") }
            .addOnFailureListener { Log.d("Failure", "Failed to add grocery") }
    }

    override fun deleteGrocery(name: String) {

    }

}