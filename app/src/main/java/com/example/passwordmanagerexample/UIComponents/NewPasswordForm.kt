package com.example.passwordmanagerexample.UIComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.passwordmanagerexample.Greeting
import com.example.passwordmanagerexample.R
import com.example.passwordmanagerexample.ui.theme.*
import com.example.passwordmanagerexample.ui.theme.LightPink

//var text =  mutableStateOf("passNaam")

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PasswordManagerExampleTheme {
        Greeting("Android")
    }
}



@Composable
fun composeFields(label: String) {
    var textFieldState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textFieldState.value,
        //modifier = Modifier.background(color=WhiteBackground),
        //onValueChange = { passNaam = it},
        onValueChange = { value -> textFieldState.value=value},
        label = { Text(label)},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = WhiteBackground,
            textColor = Blue,
            focusedLabelColor = Pink,
            unfocusedLabelColor = LightBlue,
        )
    )
}

/**
 * Username,
 * Password,
 * URL,
 * SiteName/alias,
 * Notes
 */
@Composable
fun FullScreenDialog(showDialog:Boolean, onClose:()->Unit) {

    if (showDialog) {
        Dialog(onDismissRequest =  onClose ) {
            Surface(
                //modifier = Modifier.fillMaxSize(),
                color = LightPink,
                shape = RoundedCornerShape(8.dp),
            ) {
               Box(
                    //modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier.padding(25.dp)

                ) {
                    Column (
                        //Modifier.fillMaxWidth()
                            ){
                        //Title
                        Text(buildAnnotatedString {
                            withStyle(style = ParagraphStyle(lineHeight = 165.sp)) {
                                withStyle(style = SpanStyle(color = Blue)) {
                                    append("Add Password")
                                }
                            }
                        },modifier=Modifier.padding(bottom=10.dp))

                        composeFields("Username")
                        composeFields("Password")
                        composeFields("URL")
                        composeFields("Site Name")
                        composeFields("Notes")


                        //Submit
                        //Cancel
                        Row(
                            //horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.padding(top=25.dp).align(Alignment.CenterHorizontally)
                                .fillMaxSize()

                            //horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                            Button(onClick = { /* Do something! */ },
                                colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = Color.Red
                                )) {
                                Text("Submit")
                            }
                            Spacer(Modifier.weight(1f))
                            Button(onClick = { /* Do something! */ },
                                colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = Color.Red
                                )) {
                                Text("Cancel")
                            }

                        }

                    }
                }



            }
        }
    }
}