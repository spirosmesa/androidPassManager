package com.example.passwordmanagerexample.models

class PasswordItemModel(val PasswordItem: PasswordItemDTO) {
     fun serializePassword() {

     }

    fun deserializePassword() {

    }
}

data class PasswordItemDTO(
    var username: String,
    var password: String,
    var url: String,
    var siteName: String,
    var notes: String,
)

