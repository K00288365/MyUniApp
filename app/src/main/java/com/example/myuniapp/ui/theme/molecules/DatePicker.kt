package com.example.myuniapp.ui.theme.molecules

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun DatePickerForm(
    date: String,
    onDateSelected: (String) -> Unit
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Selected Date: $date", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            DatePickerDialog(
                context,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    onDateSelected(formattedDate)
                },
                year, month, day
            ).show()
        }) {
            Text(text = "Pick Date")
        }
    }
}


fun showDatePicker(context: Context, onDateSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            onDateSelected(formattedDate)
        },
        year, month, day
    ).show()
}

fun validateDates(startDate: String, finishDate: String): String {
    if (startDate.isEmpty() || finishDate.isEmpty()) {
        return "Please select both start and finish dates."
    }
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return try {
        val start = sdf.parse(startDate)
        val finish = sdf.parse(finishDate)
        if (finish.before(start)) {
            "Finish date cannot be earlier than start date."
        } else {
            ""
        }
    } catch (e: Exception) {
        "Invalid date format."
    }
}

fun saveDatesToFirebase(
    firestore: FirebaseFirestore,
    startDate: String,
    finishDate: String,
    onComplete: (String) -> Unit
) {
    val data = mapOf("startDate" to startDate, "finishDate" to finishDate)
    firestore.collection("events")
        .add(data)
        .addOnSuccessListener {
            onComplete("Dates saved successfully!")
        }
        .addOnFailureListener { e ->
            onComplete("Dates saved successfully!")
        }
        .addOnFailureListener { e ->
            onComplete("Error saving dates: ${e.message}")
        }
}