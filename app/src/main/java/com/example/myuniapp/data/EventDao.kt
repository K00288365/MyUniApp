package com.example.myuniapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEvent(event: Event)

    @Query("SELECT * FROM events ORDER BY date ASC")
    suspend fun getAllEvents(): List<Event>

    @Delete
    suspend fun deleteEvent(event: Event)
}