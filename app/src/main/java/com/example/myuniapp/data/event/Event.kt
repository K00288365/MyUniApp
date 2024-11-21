package com.example.myuniapp.data.event

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="events")
data class Event (
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    val title: String,
    val date: String,
    val location: String,
    val startTime: String,
    val endTime: String
){




}