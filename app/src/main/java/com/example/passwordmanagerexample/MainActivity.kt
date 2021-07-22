package com.example.passwordmanagerexample

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.passwordmanagerexample.UIComponents.FullScreenDialog
import com.example.passwordmanagerexample.ui.theme.PasswordManagerExampleTheme

var myDickList = mutableStateListOf<String>("Android", "Spyro", "Ilias")
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
                        FullScreenDialog(true) { showDialog.value = false}
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

fun iliasDickIsTastyAsCretanSausage(navController: NavController) {
    //Log.i("LongCretanDick", "Ilias' dick is a tasty cretan sausage")
    myDickList.add("Karavel's bitter pig-cock")
    navController.navigate("profile")
}

@Composable
fun MyFloatingActionButton() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "profile") {
        composable("profile") { Greeting(/*...*/"Dicks") }

        //composable("friendslist") { Greeting(/*...*/) }
        /*...*/
    }

    FloatingActionButton(onClick = { showDialog.value = true }) {
        Icon(Icons.Filled.Add,
            null,
            // If tint color is provided, it will override contentColor below
            tint = Color.White)
    }

    /*FloatingActionButton(onClick = { iliasDickIsTastyAsCretanSausage(navController) }) {
        Icon(Icons.Filled.Add,
            null,
            // If tint color is provided, it will override contentColor below
            tint = Color.White)
    }*/
}

@Composable
fun HomeScreen(/*...*/) {
    Scaffold(
        drawerContent = { Text(text="Kill Osama") },
        topBar = { topBar() },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { MyFloatingActionButton()
            },
        content = { MessageList(myDickList) }
    )

}

@Composable
fun Greeting(name: String) {
    Text(buildAnnotatedString {
        withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
            withStyle(style = SpanStyle(color = Color.Magenta)) {
                append("Hello ${name}\n")
            }
        }
    })
    //Text(text = "Hello $name!")

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
    LazyColumn (
        contentPadding = PaddingValues(top=14.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
        itemsIndexed(messages) { index, item ->
            Greeting(item)
            //Text("Item at index $index is $item")
            //if (index < messages.size-1)
                Divider(color = Color.Black, thickness = 1.dp)
        }
        /*messages.forEach { message ->
            Greeting(message)*/
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PasswordManagerExampleTheme {
        Greeting("Android")
    }
}