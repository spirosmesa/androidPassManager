package com.example.passwordmanagerexample.UIComponents.HomeScreen

import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.passwordmanagerexample.*

@Composable
fun HomeScreen(/*...*/) {
    Scaffold(
        //drawerContent = { Text(text="") },
        topBar = { topBar() },
        bottomBar = { bottomBar() },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { MyFloatingActionButton()
         },
        content = { MessageList(myList) }
    )
}