package com.example.passwordmanagerexample.ViewModels

import androidx.compose.runtime.Immutable

@Immutable
data class LoginScreenModel(
    var btnText: String = "Sign Up",
    var bottomString: String = "Already got an account?",
    var bottomText: String = "Log in",
    var state: Boolean = true
)