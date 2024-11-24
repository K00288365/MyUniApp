package com.example.myuniapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myuniapp.data.event.Event
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(event: Event)

    @Update
    suspend fun update(event: Event)

    @Delete
    suspend fun delete(event: Event)

    @Query("SELECT * FROM events WHERE id = :id LIMIT 1")
     fun getEvent(id: Int): Event?


    @Query("SELECT * from events ORDER BY date ASC")
    fun getAllEvents(): Flow<List<Event>>
}