package com.padc.grocery.network.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

object FirebaseAuthManager : AuthManager {

    private val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful && it.isComplete){
                onSuccess()
            } else {
                onFailure(it.exception?.message ?: "Please Check Internet Connection")
            }
        }
    }

    override fun register(
        email: String,
        password: String,
        userName: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful && it.isComplete) {
                mFirebaseAuth.currentUser?.updateProfile(
                    UserProfileChangeRequest.Builder().setDisplayName(userName).build()
                )
                onSuccess()
            } else {
                onFailure(it.exception?.message ?: "Please check internet connection")
            }
        }
    }

    override fun getUserName(): String {
        return mFirebaseAuth.currentUser?.displayName ?: ""
    }
}