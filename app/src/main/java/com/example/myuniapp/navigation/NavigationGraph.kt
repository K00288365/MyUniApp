package com.example.myuniapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myuniapp.AdminScreens.AdminHomeScreen
import com.example.myuniapp.AdminScreens.ViewAllEvents
import com.example.myuniapp.ui.theme.pages.AddEventScreen
import com.example.myuniapp.ui.theme.pages.UpdateEventScreen


@Composable
fun NavigationGraph(
    navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            AdminHomeScreen(navController)
        }
        composable("AddEvent") {
            AddEventScreen(navController)
        }
//        composable("UpdateEvent") {
//                UpdateEventScreen(navController)
//            }

        composable("ViewAllEvents") {
            ViewAllEvents(navController)
        }

    }


}