package com.example.myuniapp.ui.theme.pages.AdminScreens

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavHostController
import com.example.myuniapp.data.repository.EventRepository
import com.example.myuniapp.ui.theme.atoms.Header
import com.example.myuniapp.ui.theme.atoms.PrimaryButton
import com.example.myuniapp.ui.theme.molecules.CardLayout
import com.google.firebase.firestore.AggregateSource
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun AdminHomeScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
            .padding(14.dp)
            .padding(top = 20.dp, bottom = 70.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(64.dp))
        }
        item {
            Header("Welcome to The Tech Society")
        }
        item {
            Description()
        }
        item {
            MemberCount()
        }
        item {
            UpcomingEvents(navController)
        }
        item {
            ContactInformation()
        }
    }
}


@Composable
fun Description() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Description:",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Button(
                onClick = { },
                colors = buttonColors(containerColor = Color(0xFF98E4CE)),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.shadow(4.dp)
            ) {
                Text(
                    text = "Edit",
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 7.dp, horizontal = 29.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "The Tech Society is a community for students passionate about technology, coding, and innovation. It's a place to learn, share ideas, and work on exciting projects together.",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .border(1.dp, Color.Black)
                .padding(10.dp),
            fontSize = 18.sp
        )
    }
}

@Composable
fun MemberCount() {
    var memberCount by remember { mutableStateOf(0) }
    val db = FirebaseFirestore.getInstance()

    LaunchedEffect(Unit) {
        val query = db.collection("users")
        val countQuery = query.count()

        countQuery.get(AggregateSource.SERVER).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val snapshot = task.result
                memberCount = snapshot.count.toInt()
                Log.d(TAG, "Count: ${snapshot.count}")
            } else {
                Log.e(TAG, "Count failed: ", task.exception)
            }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFBBDEFB))
            .border(1.dp, Color.Black)
            .padding(14.dp, 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Members:",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = memberCount.toString(),
            modifier = Modifier
                .background(Color.White)
                .padding(6.dp),
            fontSize = 20.sp
        )
    }
}

@Composable
fun UpcomingEvents(navController: NavHostController) {

    val context = LocalContext.current.applicationContext
    val repository = EventRepository(context as Application)
    val db = FirebaseFirestore.getInstance()
    val eventName = remember { mutableStateOf("") }
    val eventDate = remember { mutableStateOf("") }
    val eventLocation = remember { mutableStateOf("") }
    val eventStartTime = remember { mutableStateOf("") }
    val eventEndTime = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        val event = db.collection("events").limit(1)
        event.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result.documents.get(0)

                eventName.value = document.getString("eventName").toString()
                eventDate.value = document.getString("date").toString()
                eventLocation.value = document.getString("location").toString()
                eventStartTime.value = document.getString("startTime").toString()
                eventEndTime.value = document.getString("endTime").toString()
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "Upcoming Events",
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))

        if (eventName.value.isEmpty()) {
            Text(
                text = "Loading...",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        } else {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = "Event Name: ${eventName.value}")
                    Text(text = "Event Date: ${eventDate.value}")
                    Text(text = "Event Location: ${eventLocation.value}")
                    Text(text = "Start Time: ${eventStartTime.value}")
                    Text(text = "End Time: ${eventEndTime.value}")
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PrimaryButton(
                text = "Create",
                onClick = { navController.navigate("AddEvent") },
                modifier = Modifier.shadow(4.dp)
            )
            PrimaryButton(
                text = "View",
                onClick = { navController.navigate("ViewAllEvents") },
                modifier = Modifier.shadow(4.dp)
            )
        }
    }
}



@Composable
fun ContactInformation() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "Contact Information:",
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Black),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                CardLayout(label = "Email:", value = "techsociety@gmail.com")
                CardLayout(label = "Phone:", value = "0831234567")
            }
        }
    }
}

@Composable
fun ContactDetail(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = label,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 100.dp, end = 20.dp)
        )

        Box(
            modifier = Modifier
                .background(Color(0xFFBBDEFB))
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.CenterStart)
            )

        }
    }
}