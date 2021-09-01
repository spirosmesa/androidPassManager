package com.example.passwordmanagerexample.FirebaseRepository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception
import kotlinx.coroutines.tasks.await

class FirebaseAPI {

    object auth {
        suspend fun registerUser(email: String, password: String): String {
            return AuthenticateUserRepository.registerUser(email, password)
        }

        suspend fun loginUserCoroutine(email: String, password: String): String {
            return AuthenticateUserRepository.loginUser(email, password)
        }
    }
}