package com.example.myuniapp

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth


@Composable
fun AdminHomeScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
            item {
                Spacer(modifier = Modifier.height(64.dp))
            }
            item {
                Header()
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
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF90CAF9))
            .padding(14.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "   Welcome to " +
                    "The Tech Society",
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 30.sp)
        )
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
                onClick = {  },
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
            text = "35",
            modifier = Modifier
                .background(Color.White)
                .padding(6.dp),
            fontSize = 20.sp
        )
    }
}

@Composable
fun UpcomingEvents(navController: NavHostController) {
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
        Card(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                EventDetail("Event:", "Hackathon")
                EventDetail("Date:", "09/11/2024")
                EventDetail("Time:", "14:00 to 17:00")
                EventDetail("Location:", "Student Union")
                EventDetail("Attending:", "17")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { navController.navigate("AddEvent")  },
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
            Button(
                onClick = {  },
                colors = buttonColors(containerColor = Color(0xFF98E4CE)),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.shadow(4.dp)
            ) {
                Text(
                    text = "View Events",
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 7.dp, horizontal = 29.dp)
                )
            }
        }
    }
}

@Composable
fun EventDetail(label: String, value: String) {
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
                ContactDetail("Email", "techsociety@gmail.com")
                ContactDetail("Phone:", "0831234567")
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


