package com.example.my

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myuniapp.data.AppDatabase
import com.example.myuniapp.data.Event
import com.example.myuniapp.data.EventDao
import kotlinx.coroutines.launch

@Composable
fun AddEvent() {
    val coroutineScope = rememberCoroutineScope()
    var eventName by remember { mutableStateOf("") }
    var eventDate by remember { mutableStateOf("") }
    var eventTime by remember { mutableStateOf("") }
    var eventDescription by remember { mutableStateOf("") }
    var eventLocation by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        OutlinedTextField(
            value = eventName,
            onValueChange = { eventName = it },
            label = { Text("Event Name") },
            modifier = Modifier.fillMaxWidth(),
        )

        OutlinedTextField(
            value = eventDate,
            onValueChange = { eventDate = it },
            label = { Text("Event Date") },
            modifier = Modifier.fillMaxWidth(),
        )

        OutlinedTextField(
            value = eventTime,
            onValueChange = { eventTime = it },
            label = { Text("Event Time") },
            modifier = Modifier.fillMaxWidth(),
        )

        OutlinedTextField(
            value = eventDescription,
            onValueChange = { eventDescription = it },
            label = { Text("Event Description") },
            modifier = Modifier.fillMaxWidth(),
        )

        OutlinedTextField(
            value = eventLocation,
            onValueChange = { eventLocation = it },
            label = { Text("Event Location") },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val event = Event(
                    title = eventName,
                    date = eventDate,
                    time = eventTime,
                    description = eventDescription,
                    location = eventLocation
                )

                coroutineScope.launch {
                    EventRepository.insert(event)
                    Log.d("Event", "Event saved to Room database")
                }
            }
        ) {
            Text("Save Event")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventEntryScreenPreview() {
    AddEvent()
}