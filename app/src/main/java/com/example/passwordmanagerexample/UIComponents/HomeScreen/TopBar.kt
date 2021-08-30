package com.example.passwordmanagerexample.UIComponents.HomeScreen

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun topBar() {
    TopAppBar(
        title = {
            Text(text = "Password Manager")
        },
        elevation = 2.dp
    )
}