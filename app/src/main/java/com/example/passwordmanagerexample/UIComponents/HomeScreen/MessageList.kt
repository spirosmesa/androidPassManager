package com.example.passwordmanagerexample.UIComponents.HomeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp

@Composable
fun MessageList(messages: List<String>) {
    LazyColumn (
        contentPadding = PaddingValues(top=14.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        itemsIndexed(messages) { index, item ->
            Text(buildAnnotatedString {
                Text(text = "Hello $item!")
            })
            //Greeting(item)
            Divider(color = Color.Black, thickness = 1.dp)
        }
    }
}