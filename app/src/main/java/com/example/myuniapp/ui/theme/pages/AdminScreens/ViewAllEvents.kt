package com.example.myuniapp.ui.theme.pages.AdminScreens

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myuniapp.data.event.Event
import com.example.myuniapp.data.repository.EventRepository
import com.example.myuniapp.ui.theme.atoms.PrimaryButton
import com.example.myuniapp.ui.theme.atoms.SecondaryButton
import com.example.myuniapp.ui.theme.molecules.CardLayout
import kotlinx.coroutines.launch

@Composable
fun ViewAllEvents(navController: NavController) {
    val context = LocalContext.current.applicationContext
    val repository = remember { EventRepository(context as Application) }

    val coroutineScope = rememberCoroutineScope()
    val events = remember { mutableStateOf<List<Event>>(emptyList()) }

    LaunchedEffect(Unit) {
        repository.getAllEvents().collect { eventList ->
            events.value = eventList
        }
    }

    Column(
        modifier = Modifier
            .background(Color(0xFFF4F9FD))
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tech Society Events",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .border(1.dp, Color.Black)
                .padding(8.dp)
        )

        Text(
            text = "Upcoming Events",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (events.value.isEmpty()) {
            Text(
                text = "No upcoming events available.",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 16.dp)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(events.value) { event ->
                    EventCard(event = event, navController = navController, repository = repository)
                }
            }
        }
    }
    }

    @Composable
    private fun EventCard(event: Event, navController: NavController, repository: EventRepository) {
        val coroutineScope = rememberCoroutineScope()


        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shadowElevation = 4.dp,
            color = Color.White,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(5.dp)
            ) {
                CardLayout(label = "Event:", value = event.title)
                CardLayout(label = "Date:", value = event.date)
                CardLayout(label = "Time:", value = "${event.startTime} to ${event.endTime}")
                CardLayout(label = "Location:", value = event.location)

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    PrimaryButton(
                        text = "Update",
                        onClick = { navController.navigate("UpdateEvent/${event.id}") },
                        modifier = Modifier.shadow(4.dp)
                    )
                    SecondaryButton(
                        "Delete",
                        onClick = {
                            coroutineScope.launch {
                                repository.delete(event)
                            }
                        },
                        modifier = Modifier.shadow(4.dp)
                    )
                }

            }
        }
}

    @Composable
    fun ViewAllEventsPreview() {
        val navController = rememberNavController()
        ViewAllEvents(navController = navController)
    }
