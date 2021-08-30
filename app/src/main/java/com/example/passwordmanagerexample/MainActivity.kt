package com.example.passwordmanagerexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.passwordmanagerexample.UIComponents.FullScreenDialog
import com.example.passwordmanagerexample.UIComponents.HomeScreen.HomeScreen
import com.example.passwordmanagerexample.ui.theme.BottomBarItem
import com.example.passwordmanagerexample.ui.theme.PasswordManagerExampleTheme

var myList = mutableStateListOf<String>("Android", "Spyro", "Ilias")
val showDialog = mutableStateOf(false)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordManagerExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen()
                    if(showDialog.value) {
                        FullScreenDialog(showDialog) { showDialog.value = false}
                    }
                }
            }
        }
    }
}
/*

@Composable
fun Greeting(name: String) {
    Text(buildAnnotatedString {
        Text(text = "Hello $name!")
    })
}*/
