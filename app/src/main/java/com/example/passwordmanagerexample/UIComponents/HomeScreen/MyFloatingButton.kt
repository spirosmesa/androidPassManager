package com.example.passwordmanagerexample.UIComponents.HomeScreen

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(onClick = { showDialog.value = true }) {
        Icon(
            Icons.Filled.Add,
            null,
            tint = Color.White)
    }
}