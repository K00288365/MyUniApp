package com.example.myuniapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.my.AddEvent
import com.example.myuniapp.AdminHomeScreen



@Composable
fun NavigationGraph(
    navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            AdminHomeScreen(navController)
        }

        composable("AddEvent") {
            AddEvent(navController)
        }

    }


}