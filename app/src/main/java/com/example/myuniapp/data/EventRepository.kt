package com.example.myuniapp.data

import kotlinx.coroutines.flow.Flow

interface EventRepository {
        fun getAllEventsStream(): Flow<List<Event>>

        fun getEventStream(id: Int): Flow<Event?>

        suspend fun insert(event: Event)

        suspend fun delete(event: Event)

        suspend fun update(event: Event)
    }


