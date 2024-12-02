package com.example.myuniapp.navigation

sealed class Screen(
    val route: String
) {
    object Home : Screen("home")
    object AddEvent : Screen("AddEvent")
    object ViewEvents : Screen("ViewAllEvents")
}

val screens = listOf(
    Screen.Home,
    Screen.AddEvent,
    Screen.ViewEvents
)