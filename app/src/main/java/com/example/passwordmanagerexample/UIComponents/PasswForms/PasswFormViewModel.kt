package com.example.passwordmanagerexample.UIComponents.PasswForms

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

object PasswFormViewModel : ViewModel() {
    val passwordState = mutableStateOf("")
    val userState = mutableStateOf("")
    val urlState = mutableStateOf("")
    val siteNameState = mutableStateOf("")
    val notesState = mutableStateOf("")

    fun passwordFieldState(passw: String) {
        this.passwordState.value = passw
    }

    fun onSubmitButtonClick(showDialog: MutableState<Boolean>) {
        Log.i("value state: ", "${passwordState.value} ${userState.value}")
        showDialog.value=false
    }

    fun onCancelButtonClick(showDialog: MutableState<Boolean>) {
        passwordState.value = ""
        userState.value = ""
        urlState.value= ""
        siteNameState.value = ""
        notesState.value = ""
        showDialog.value=false
    }

}