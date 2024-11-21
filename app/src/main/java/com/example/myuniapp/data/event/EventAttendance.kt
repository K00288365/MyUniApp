package com.example.myuniapp.data.event

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event_attendance")
data class EventAttendance (
    @PrimaryKey(autoGenerate = true) val id:Int =0,
    val eventId: Int,
    val userId: String,
    val isAttending: Boolean

)