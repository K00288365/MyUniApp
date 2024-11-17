package com.example.fourpageapp.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material3.DrawerState
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()

    Column {
        Text("Navigate to: ")

        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()
                navController.navigate("home")
            }
        }) {
            Text("Home")
        }

        TextButton(onClick = {
            coroutineScope.launch {
                drawerState.close()
                navController.navigate("AddEvent")
            }
        }) {
            Text("Add Event")
        }
    }
}
