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
import com.example.passwordmanagerexample.ui.theme.BottomBarItem
import com.example.passwordmanagerexample.ui.theme.PasswordManagerExampleTheme

var myList = mutableStateListOf<String>("Android", "Spyro", "Ilias")
private val showDialog = mutableStateOf(false)
//Needs to be in a Composable e.g. Surface
//var showDialog by remember { mutableStateOf(false) }

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

@Composable
fun topBar() {
    TopAppBar(
        title = {
            Text(text = "Password Manager")
        },
        elevation = 2.dp
    )
}

@Composable
fun bottomBar() {

    val items = listOf(
        BottomBarItem.Home,
        BottomBarItem.Account,
        BottomBarItem.Settings,
    )
    
    BottomNavigation() {
        items.forEach { item ->
            val toggle = remember { mutableStateOf(false) }
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onPrimary,
                alwaysShowLabel = true,
                selected = toggle.value,
                onClick = {
                    toggle.value = !toggle.value
                }
            )
        }
    }
}

@Composable
fun MyFloatingActionButton() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "profile") {
        composable("profile") { Greeting(/*...*/"") }
    }

    FloatingActionButton(onClick = { showDialog.value = true }) {
        Icon(Icons.Filled.Add,
            null,
            // If tint color is provided, it will override contentColor below
            tint = Color.White)
    }
}

@Composable
fun HomeScreen(/*...*/) {
    Scaffold(
        drawerContent = { Text(text="Kill Osama") },
        topBar = { topBar() },
        bottomBar = { bottomBar() },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { MyFloatingActionButton()
            },
        content = { MessageList(myList) }
    )
}

@Composable
fun Greeting(name: String) {
    Text(buildAnnotatedString {
        Text(text = "Hello $name!")
    })
}

@Composable
fun MessageList(messages: List<String>) {
    LazyColumn (
        contentPadding = PaddingValues(top=14.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
        itemsIndexed(messages) { index, item ->
            Greeting(item)
                Divider(color = Color.Black, thickness = 1.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PasswordManagerExampleTheme {
        Greeting("Android")
    }
}