/*
package com.example.passwordmanagerexample.ViewModels

import android.text.TextUtils
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
    private val _buttonType = MutableStateFlow(LoginScreenModel())
    val buttonType: StateFlow<LoginScreenModel> get() = _buttonType

    val emailState = mutableStateOf("")
    val passwordState = mutableStateOf("")

    val errorMessage = mutableStateOf("")

    var validatedInput = mutableStateOf(false)

    fun onSwapType() {
        _buttonType.value.state = !_buttonType.value.state
        if (_buttonType.value.state) {
            _buttonType.value = _buttonType.value.copy(
                "Sign Up",
                "Already got an account?",
                "Log in",
                true
            )
        } else {
            _buttonType.value = _buttonType.value.copy(
                "Log in",
                "Not an account yet?",
                "Sign Up",
                false
            )
        }
//        _buttonType.emit(buttonType.value)
        Log.i("JUST GOT IN", "BUT NO UPDATES HAPPEN ${_buttonType.value.state}")
    }

    fun onEmailFieldChanged(email: String) {
        this.emailState.value = email
    }

    fun onPasswordFieldChanged(password: String) {
        this.passwordState.value = password
    }

    fun onSubmitBtnPressed(email: String, password: String, navController: NavController) {

        validateInput(email, password)
        if (validatedInput.value) {
            errorMessage.value = "Empty Username or Password!"
            return
        }

        if (_buttonType.value.state) {
//            errorMessage.value = Connection.RegisterUser(email, password)
//            Log.i("REPSONE REGISTER", errorMessage.value)
            viewModelScope.launch {
                authenticateUser(
                    FirebaseAPI.registerUser(email, password),
                    navController = navController
                )
            }
        } else {
            viewModelScope.launch {
                authenticateUser(
                    FirebaseAPI.loginUserCoroutine(email, password),
                    navController = navController
                )
            }
//            Connection.LoginUserCoroutine(email, password)
//            Connection.LoginUser("yolanda37@lula.com", "lula137")
        }
    }

    private suspend fun authenticateUser(function: String, navController: NavController) {
        function.let { authResult ->
            if (authResult != "OK") {
                errorMessage.value = authResult
                validatedInput.value = true
                Log.i("GET ON ELSE NAV", errorMessage.value)
            } else {
                Log.i("GET ON ELSE NAV", errorMessage.value)
//                FirebaseAPI.addUserProfile()
                navController.navigate("welcome")

            }

        }
    }

    fun onSuccess(navController: NavController) {
        if (FirebaseAuth.getInstance().currentUser != null) {
            navController.navigate("welcome")
        }
    }

    private fun validateInput(email: String, password: String) {
        if (TextUtils.isEmpty(email)) {
            validatedInput.value = true
        }
        if (TextUtils.isEmpty(password)) {
            validatedInput.value = true
        }
    }
}*/
