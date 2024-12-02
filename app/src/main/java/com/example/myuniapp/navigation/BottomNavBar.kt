package com.example.myuniapp.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myuniapp.MyApp
import com.example.myuniapp.ui.theme.theme.myPrimaryColour

@Composable
fun BottomNavBar(navController: NavHostController) {
    val icons = mapOf(
        Screen.Home to IconGroup(
            filledIcon = Icons.Filled.Home,
            outlineIcon = Icons.Outlined.Home,
            label = "Home"
        ),
        Screen.AddEvent to IconGroup(
            filledIcon = Icons.Filled.AddCircle,
            outlineIcon = Icons.Outlined.AddCircle,
            label = "Add Event"
        ),
        Screen.ViewEvents to IconGroup(
            filledIcon = Icons.Filled.Search,
            outlineIcon = Icons.Outlined.Search,
            label = "View Events"
        )
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier.height(65.dp),
        contentColor = myPrimaryColour
    ) {
        screens.forEach { screen ->
            val isSelected = currentDestination?.route == screen.route
            val labelText = icons[screen]?.label ?: ""

            NavigationBar {
                val navBackStackEntry by
                navController.currentBackStackEntryAsState()
                val currentDestination =
                    navBackStackEntry?.destination
                screens.forEach { screen ->
                    val isSelected = currentDestination?.route == screen.route
                    val labelText = icons[screen]!!.label

                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = (
                                        if (isSelected)
                                            icons[screen]!!.filledIcon
                                        else
                                            icons[screen]!!.outlineIcon),
                                contentDescription = labelText
                            )
                        },
                        label = { Text(labelText) },
                        selected = isSelected,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState =
                                        true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

    @Preview(showBackground = true)
    @Composable
    fun BottomNavBarPreview() {
        val navController = rememberNavController()
        BottomNavBar(navController = navController)
    }