package com.example.myuniapp.ui.theme.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimeInputFields(
    startTime: String,
    endTime: String,
    onStartTimeChange: (String) -> Unit,
    onEndTimeChange: (String) -> Unit,
    startTimeError: String,
    endTimeError: String
) {
    Column {
        Text(text = "Time:", fontSize = 18.sp, color = Color.Black)
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            TextField(
                value = startTime,
                onValueChange = onStartTimeChange,
                placeholder = { Text("Start Time") },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            Text(text = "To", fontSize = 18.sp, color = Color.Black)
            TextField(
                value = endTime,
                onValueChange = onEndTimeChange,
                placeholder = { Text("End Time") },
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            )
        }

        if (startTimeError.isNotEmpty()) {
            Text(text = startTimeError, color = Color.Red, fontSize = 14.sp)
        }
        if (endTimeError.isNotEmpty()) {
            Text(text = endTimeError, color = Color.Red, fontSize = 14.sp)
        }
    }
}
