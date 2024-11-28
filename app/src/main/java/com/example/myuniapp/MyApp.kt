package com.example.myuniapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.fourpageapp.navigation.DrawerContent
import com.example.myuniapp.UserScreens.RegisterUser
import com.example.myuniapp.navigation.NavigationGraph
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    var isUserLoggedIn by remember { mutableStateOf(Firebase.auth.currentUser != null) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    var showRegisterScreen by remember { mutableStateOf(false) }

    if (isUserLoggedIn) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    DrawerContent(navController = navController, drawerState = drawerState)
                }
            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("TUS Society") },
                        navigationIcon = {
                            IconButton(onClick = {
                                coroutineScope.launch {
                                    if (drawerState.isClosed) {
                                        drawerState.open()
                                    } else {
                                        drawerState.close()
                                    }
                                }
                            }) {
                                Icon(Icons.Filled.Menu, contentDescription = "Menu Icon")
                            }
                        },
                        actions = {
                            IconButton(onClick = {
                                Firebase.auth.signOut()
                                isUserLoggedIn = false
                            }) {
                                Icon(Icons.Filled.ExitToApp, contentDescription = "Logout")
                            }

                        }
                    )
                }
            ) { paddingValues ->
                NavigationGraph(
                    navController = navController, paddingValues)
            }
        }
    } else {
        if (showRegisterScreen) {
            RegisterUser(
                onRegisterSuccess = { isUserLoggedIn = true },
                SwitchToLogin = { showRegisterScreen = false }
            )
        } else {
            LoginScreen(
                onLoginSuccess = { isUserLoggedIn = true },
                SwitchToRegister = { showRegisterScreen = true }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
