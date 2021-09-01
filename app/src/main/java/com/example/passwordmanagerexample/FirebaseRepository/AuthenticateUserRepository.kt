package com.example.passwordmanagerexample.FirebaseRepository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class AuthenticateUserRepository {

    companion object {
        suspend fun registerUser(email: String, password: String): String {
            Log.i("ERRRRRRR", "HERE WE GO")
            try {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).await()
//                FirebaseAPI.addUserProfile()
                return "OK"
            } catch (e: Exception) {
                Log.i("ERRRRRRR", e.localizedMessage!!)
                return e.localizedMessage!!
            }

        }


        suspend fun loginUser(email: String, password: String): String {
            val currentUser = FirebaseAuth.getInstance().currentUser
            if (currentUser != null) {
                Log.i("HELLOYOYO", "USER IS LOGEDIN  " + currentUser.uid)
                return "ALREADY LOGGED IN"
            }
            try {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).await()
                return "OK"
            } catch (e: Exception) {
                return e.localizedMessage!!
            }
        }
    }
}