package com.example.passwordmanagerexample.UIComponents.HomeScreen

import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.passwordmanagerexample.*
import com.example.passwordmanagerexample.UIComponents.FullScreenDialog

var myList = mutableStateListOf("Android", "Spyro", "Ilias")
val showDialog = mutableStateOf(false)

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
    if(showDialog.value) {
        FullScreenDialog(showDialog) { showDialog.value = false}
    }
}