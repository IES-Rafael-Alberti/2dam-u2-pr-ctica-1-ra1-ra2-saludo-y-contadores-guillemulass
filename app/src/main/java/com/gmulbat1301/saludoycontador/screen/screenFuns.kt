package com.gmulbat1301.saludoycontador.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainScreen() {
    var greetingsString by rememberSaveable { mutableStateOf("") }
    var openDialog by rememberSaveable { mutableStateOf(false) }
    var myName by rememberSaveable { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Button(
            onClick = {
                openDialog = true
            },
            modifier = Modifier
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text(
                text = "Saludar"
            )
        }
        Text(
            text = greetingsString
        )

        if (openDialog) {

            AlertDialog(
                onDismissRequest = {
                    openDialog = true
                },

                {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        OutlinedTextField(
                            value = myName,
                            onValueChange = { myName = it}
                        )
                        Row(
                            modifier = Modifier.padding(10.dp)
                        ){
                            Button(
                                onClick = {
                                    greetingsString = "Hola, $myName"
                                    openDialog = false
                                },
                                modifier = Modifier.padding(10.dp)
                            ) {
                                Text("A")
                            }
                            Button(
                                onClick = {
                                    myName = ""
                                },
                                modifier = Modifier.padding(10.dp)
                            ) {
                                Text("L")
                            }
                            Button(
                                onClick = {
                                    openDialog = false
                                },
                                modifier = Modifier.padding(10.dp)
                            ) {
                                Text("C")
                            }
                        }
                    }
                }

            )
        }
    }
}
