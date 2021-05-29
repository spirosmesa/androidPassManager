package com.example.passwordmanagerexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordmanagerexample.ui.theme.PasswordManagerExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordManagerExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen()
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
//                        navigationIcon = {
//                            IconButton(onClick = { }) {
//                                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Btn")
//                            }
//                        },
        //backgroundColor = Color.Transparent,
        //contentColor = Color.Gray,
        elevation = 2.dp
    )
}

@Composable
fun MyFloatingActionButton() {
    ExtendedFloatingActionButton(icon= {Icon(Icons.Filled.Favorite,"") },
    text = {},
    onClick = {},
    )
}

@Composable
fun HomeScreen(/*...*/) {
    Scaffold(
        drawerContent = { Text(text="Kill Osama") },
        topBar = { topBar() },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { MyFloatingActionButton()
            },
        content = { MessageList(arrayListOf("Android", "Spyro", "Ilias")) }
    )
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
//    Column(modifier = Modifier.fillMaxSize()) {
//        Text(
//            text = "First item",
//            modifier = Modifier.weight(1f)
//        )
//        Text(
//            text = "Second item",
//            modifier = Modifier.weight(1f)
//        )
//    }
}

@Composable
fun MessageList(messages: List<String>) {
    Column {
        messages.forEach { message ->
            Greeting(message)
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