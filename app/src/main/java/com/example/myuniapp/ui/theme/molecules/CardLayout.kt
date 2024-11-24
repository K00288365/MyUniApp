package com.example.myuniapp.ui.theme.molecules

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardLayout(label: String, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 4.dp)
    ) {
        Text(
            text = label,
            fontSize = 17.sp,
            modifier = Modifier.width(80.dp),
            textAlign = TextAlign.Right,
            fontWeight = FontWeight.Bold
        )
        Surface(

            color = Color(0xFFDAF0FF),
            shadowElevation = 4.dp,
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.padding(start = 8.dp)
//                .background(Color(0xFFBBDEFB)),
        ) {
            Text(
                text = value,
                fontSize = 17.sp,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 5.dp),
//        horizontalArrangement = Arrangement.Start,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Spacer(modifier = Modifier.weight(1f))
//
//        Text(
//            text = label,
//            fontSize = 20.sp,
//            modifier = Modifier.padding(10.dp)
//        )
//
//        Box(
//            modifier = Modifier
//                .background(Color(0xFFBBDEFB))
//                .fillMaxWidth()
//                .padding(8.dp)
//        ) {
//            Text(
//                text = value,
//                fontSize = 18.sp,
//                modifier = Modifier.align(Alignment.CenterStart)
//            )
//        }
//    }
//}