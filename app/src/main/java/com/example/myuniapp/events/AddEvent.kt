package com.example.my

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myuniapp.DefaultSnackbar
import com.example.myuniapp.data.AppDatabase
import com.example.myuniapp.data.event.Event
import com.example.myuniapp.data.repository.EventRepository
import kotlinx.coroutines.launch

@Composable
fun AddEvent(navController: NavController) {
    var eventName by remember { mutableStateOf("") }
    var eventDate by remember { mutableStateOf("") }
    var startTime by remember { mutableStateOf("") }
    var endTime by remember { mutableStateOf("") }
    var place by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()

    val snackbarHostState = remember { SnackbarHostState() }

    val context = LocalContext.current.applicationContext
    val repository = EventRepository(context as Application)

    fun resetForm() {
        eventName = ""
        eventDate = ""
        startTime = ""
        endTime = ""
        place = ""
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(top = 70.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Create Event",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(fontSize = 30.sp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp)
        ) {
            Text(
                text = "Event Name:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
            TextField(
                value = eventName,
                onValueChange = { eventName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFBBDEFB), shape = RoundedCornerShape(4.dp))
                    .shadow(4.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Date:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
            TextField(
                value = eventDate,
                onValueChange = { eventDate = it },
                placeholder = { Text("dd/mm/yyyy") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFBBDEFB), shape = RoundedCornerShape(4.dp))
                    .shadow(4.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Time:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = startTime,
                    onValueChange = { startTime = it },
                    placeholder = { Text("00:00") },
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFFBBDEFB), shape = RoundedCornerShape(4.dp))
                        .shadow(4.dp)
                        .border(1.dp, Color.Black),
                )

                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "To",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = endTime,
                    onValueChange = { endTime = it },
                    placeholder = { Text("00:00") },
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFFBBDEFB), shape = RoundedCornerShape(4.dp))
                        .shadow(4.dp)
                        .border(1.dp, Color.Black)
                )
            }

            Spacer(modifier = Modifier.height(13.dp))

            Text(
                text = "Place:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
            TextField(
                value = place,
                onValueChange = { place = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFBBDEFB), shape = RoundedCornerShape(4.dp))
                    .shadow(4.dp)
            )
        }
        Spacer(modifier = Modifier.height(26.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    val event = Event(
                        title = eventName,
                        date = eventDate,
                        startTime = startTime,
                        endTime = endTime,
                        location = place
                    )
                    coroutineScope.launch {
                        repository.insert(event)

                        snackbarHostState.showSnackbar(
                            message = "Event Added Successfully",
                            actionLabel = "Undo"
                        )
                    }
                    resetForm()
                },
                colors = buttonColors(containerColor = Color(0xFF98E4CE)),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.shadow(4.dp)
            ) {
                Text(
                    text = "Create",
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 7.dp, horizontal = 29.dp)
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(
                onClick = {resetForm() },
                colors = buttonColors(containerColor = Color(0xFFE498A5)),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.shadow(4.dp)
            ) {
                Text(
                    text = "Reset",
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 7.dp, horizontal = 33.dp)
                )
            }
        }
        SnackbarHost(
            hostState = snackbarHostState,
            snackbar = { data ->
                DefaultSnackbar(
                    data = data,
                    modifier = Modifier.padding(16.dp),
                    onDismiss = { data.dismiss() }
                )
            }
        )
    }
}


//@Preview(showBackground = true)
//@Composable
//fun EventEntryScreenPreview() {
//    AddEvent()
//}