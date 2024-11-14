package com.example.myuniapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(tableName ="events")
data class Event (
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    val title: String,
    val date: String,
    val description: String,
    val location: String,
    val time: String
){




}