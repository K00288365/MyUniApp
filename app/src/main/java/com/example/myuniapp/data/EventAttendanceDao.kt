package com.example.myuniapp.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface EventAttendanceDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAttendance(attendance: EventAttendance)

    @Query("SELECT * FROM event_attendance WHERE userId = :userId")
    suspend fun getAttendance(userId: Int): List<EventAttendance>

    @Delete
    suspend fun  deleteAttendance(attendance: EventAttendance)
}