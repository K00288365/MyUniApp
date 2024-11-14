package com.example.myuniapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun MyApp() {
    var isUserLoggedIn by remember { mutableStateOf(Firebase.auth.currentUser != null) }

    if (isUserLoggedIn) {
        WelcomeScreen()
    } else {
        LoginScreen(onLoginSuccess = {
            isUserLoggedIn = true
        })
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
