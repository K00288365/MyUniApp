package com.example.myuniapp.ui.theme.organism

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myuniapp.ui.theme.atoms.PrimaryButton
import com.example.myuniapp.ui.theme.atoms.SecondaryButton
import com.example.myuniapp.ui.theme.molecules.DatePickerForm
import com.example.myuniapp.ui.theme.molecules.FormField
import com.example.myuniapp.ui.theme.molecules.TimeInputFields

@Composable
fun EventForm(
    eventName: String,
    eventDate: String,
    startTime: String,
    endTime: String,
    location: String,
    eventNameError: String,
    eventDateError: String,
    startTimeError: String,
    endTimeError: String,
    locationError: String,
    onEventNameChange: (String) -> Unit,
    onEventDateChange: (String) -> Unit,
    onStartTimeChange: (String) -> Unit,
    onEndTimeChange: (String) -> Unit,
    onLocationChange: (String) -> Unit,
    submitForm: () -> Unit,
    resetForm: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        FormField(
            "Event Name", value = eventName, onValueChange = onEventNameChange
        )


        if (eventNameError.isNotEmpty()) {
            Text(text = eventNameError, color = Color.Red, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))


        Text(text = "Event Date", fontSize = 16.sp)
        DatePickerForm(
            date = eventDate,
            onDateSelected = { selectedDate -> onEventDateChange(selectedDate) }
        )

        Spacer(modifier = Modifier.height(8.dp))
        TimeInputFields(
            startTime = startTime,
            endTime = endTime,
            onStartTimeChange = onStartTimeChange,
            onEndTimeChange = onEndTimeChange,
            startTimeError = startTimeError,
            endTimeError = endTimeError
        )

        Spacer(modifier = Modifier.height(8.dp))
        FormField("Location", value = location, onValueChange = onLocationChange)
        if (locationError.isNotEmpty()) {
            Text(text = locationError, color = Color.Red, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            PrimaryButton(text = "Submit", onClick = submitForm)
            SecondaryButton(text = "Reset", onClick = resetForm)
        }
    }
}
