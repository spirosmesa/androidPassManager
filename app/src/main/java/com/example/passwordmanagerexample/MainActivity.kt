package com.example.passwordmanagerexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.passwordmanagerexample.UIComponents.FullScreenDialog
import com.example.passwordmanagerexample.UIComponents.HomeScreen.HomeScreen
import com.example.passwordmanagerexample.UIComponents.LoginScreen.LoginScreen
import com.example.passwordmanagerexample.ViewModels.LoginScreenViewModel
import com.example.passwordmanagerexample.ui.theme.BottomBarItem
import com.example.passwordmanagerexample.ui.theme.PasswordManagerExampleTheme
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.ExperimentalCoroutinesApi


class MainActivity : ComponentActivity() {

    private val loginScreenViewModel by viewModels<LoginScreenViewModel>()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val title = remember {
                mutableStateOf("My Passwords")
            }
            PasswordManagerExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //HomeScreen()
                    AppContent(titleChanged = { newTitle ->
                        title.value = newTitle
                    },
                        title = title.value)
                }
            }
        }
    }


    lateinit var navController2: NavController

    @ExperimentalCoroutinesApi
    @Composable
    private fun AppContent(titleChanged: (String) -> Unit, title: String) {
        val navController = rememberNavController()
        var startScreen = "login"
        if (FirebaseAuth.getInstance().currentUser != null) {
            startScreen = "welcome"
        }
        NavHost(navController = navController, startDestination = startScreen) {
            navController2 = navController
            composable("login") {
                LoginScreen(
                    viewModel = loginScreenViewModel,
                    navController = navController
                )
            }

            composable("welcome") {
                titleChanged.invoke("My Passwords")
                HomeScreen()
            }


        }
    }
}
