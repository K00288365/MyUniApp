package com.example.myuniapp.ui.theme.molecules

import androidx.browser.trusted.sharing.ShareTarget.FileFormField
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormField(label: String, value: String, onValueChange: (String) -> Unit) {
    Text(text = label, fontSize = 16.sp, color = Color.Black)
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFBBDEFB), shape = RoundedCornerShape(4.dp))
            .shadow(4.dp),
        placeholder = { Text("Enter $label") }

    )

}







