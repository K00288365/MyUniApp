package com.example.myuniapp.ui.theme.pages.AdminScreens

import com.example.myuniapp.ui.theme.organism.EventForm

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myuniapp.validateEndTime
import com.example.myuniapp.validateEventDate
import com.example.myuniapp.validateEventName
import com.example.myuniapp.validateLocation
import com.example.myuniapp.validateStartTime
import com.example.myuniapp.data.event.Event
import com.example.myuniapp.data.repository.EventRepository
import com.example.myuniapp.ui.theme.atoms.Header
import com.example.myuniapp.ui.theme.molecules.Snackbar
import kotlinx.coroutines.launch

@Composable
//fun UpdateEventScreen(navController: NavController, eventId: Int) {
    fun UpdateEventScreen(navController: NavController) {

        var eventName by remember { mutableStateOf("") }
    var eventDate by remember { mutableStateOf("") }
    var startTime by remember { mutableStateOf("") }
    var endTime by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    var eventNameError by remember { mutableStateOf("") }
    var eventDateError by remember { mutableStateOf("") }
    var startTimeError by remember { mutableStateOf("") }
    var endTimeError by remember { mutableStateOf("") }
    var locationError by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    val context = LocalContext.current.applicationContext
    val repository = EventRepository(context as Application)

//    LaunchedEffect(eventId) {
//        repository.getEventById(eventId).collect { event ->
//            event?.let {
//                eventName = it.title
//                eventDate = it.date
//                startTime = it.startTime
//                endTime = it.endTime
//                location = it.location
//            }
//        }
//    }

    fun resetForm() {
        eventName = ""
        eventDate = ""
        startTime = ""
        endTime = ""
        location = ""

        eventNameError = ""
        eventDateError = ""
        startTimeError = ""
        endTimeError = ""
        locationError = ""
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(Modifier.padding(30.dp))
        Header("Update Event")

        EventForm(
            eventName = eventName,
            onEventNameChange = { eventName = it },
            eventDate = eventDate,
            onEventDateChange = { eventDate = it },
            startTime = startTime,
            onStartTimeChange = { startTime = it },
            endTime = endTime,
            onEndTimeChange = { endTime = it },
            location = location,
            onLocationChange = { location = it },
            eventNameError = eventNameError,
            eventDateError = eventDateError,
            startTimeError = startTimeError,
            endTimeError = endTimeError,
            locationError = locationError,

            submitForm = {
                eventNameError = validateEventName(eventName)
                eventDateError = validateEventDate(eventDate)
                startTimeError = validateStartTime(startTime)
                endTimeError = validateEndTime(endTime)
                locationError = validateLocation(location)

                if (eventNameError.isEmpty() && eventDateError.isEmpty() && startTimeError.isEmpty() &&
                    endTimeError.isEmpty() && locationError.isEmpty()
                ) {
//                    val updatedEvent = Event(
//                        id = eventId,
//                        title = eventName,
//                        date = eventDate,
//                        startTime = startTime,
//                        endTime = endTime,
//                        location = location
//                    )

                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Event updated successfully!")
                        navController.navigate("ViewAllEvents")
                    }
                } else {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Please fix errors.")
                    }
                }
            },
            resetForm = { resetForm() }
        )

        Snackbar(snackbarHostState = snackbarHostState)
    }
}

